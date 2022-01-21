package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author JianhuiChen
 * @description 树状结构工具类 提供通用树结构的平铺/聚合方法
 * @date 2019-08-29
 */
public class TreeUtil {

    /**
     * 遍历树结构
     *
     * @param root              节点树结构
     * @param loadChildrenNodes 加载树的子节点列表函数 接收一个节点 返回节点的子结构
     * @param behavior          遍历到的节点行为
     * @param <T>               树节点对象
     */
    public static <T> void traversing(List<T> root, Function<T, List<T>> loadChildrenNodes, Consumer<T> behavior) {
        Stack<T> stack = new Stack<>();
        root.forEach(stack::push);
        while (!stack.isEmpty()) {
            T o = stack.pop();
            behavior.accept(o);
            List<T> childrens = loadChildrenNodes.apply(o);
            if (childrens != null && childrens.size() > 0) {
                childrens.forEach(stack::push);
            }
        }
    }

    /**
     * 平铺树结构
     *
     * @param root              节点树结构
     * @param loadChildrenNodes 加载树的子节点列表函数 接收一个节点 返回节点的子结构
     * @param <T>               树节点对象
     * @return 平铺结构
     */
    public static <T> List<T> tileTree(List<T> root, Function<T, List<T>> loadChildrenNodes) {
        List<T> list = new ArrayList<>();
        traversing(root, loadChildrenNodes, list::add);
        return list;
    }

    /**
     * 打印树信息
     *
     * @param list              树结构列表
     * @param loadChildrenNodes 加载树的子节点列表函数 接收一个节点 返回节点的子结构
     * @param <T>               树节点对象
     */
    public static <T> void printTree(List<T> list, Function<T, List<T>> loadChildrenNodes) {
        System.out.println("---------- Tree Nodes Print ----------");
        traversing(list, loadChildrenNodes, System.out::println);
        System.out.println("---------- Tree Nodes Print ----------");
    }

    /**
     * 聚合树结构
     *
     * @param list          节点列表结构
     * @param loadKey       节点唯一key读取 接收一个节点 返回节点的唯一key
     * @param loadParentKey 节点父节点key读取 接收一个节点 返回节点的父节点key
     * @param write         节点子项写入函数 接收待写入节点与节点子项 负责将子节点写入
     * @param <T>           节点对象
     * @param <R>           节点唯一key对象
     * @return 树结构
     */
    public static <T, R> List<T> polymerizationTree(List<T> list, Function<T, R> loadKey, Function<T, R> loadParentKey, BiConsumer<T, List<T>> write) {
        List<T> root = list.stream().filter(o -> loadParentKey.apply(o) == null).collect(Collectors.toList());
        Stack<T> stack = new Stack<>();
        root.forEach(stack::push);
        while (!stack.isEmpty()) {
            T o = stack.pop();
            R key = loadKey.apply(o);
            List<T> childrens = list.stream()
                    .filter(k -> key.equals(loadParentKey.apply(k)))
                    .collect(Collectors.toList());
            write.accept(o, childrens);
            if (childrens.size() > 0) {
                childrens.forEach(stack::push);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        List<Node> listNodes = new ArrayList<>();
        listNodes.add(new Node(1, "根节点1", null));
        listNodes.add(new Node(2, "根节点2", null));
        listNodes.add(new Node(3, "根节点3", null));
        listNodes.add(new Node(4, "1-1", 1));
        listNodes.add(new Node(5, "1-2", 1));
        listNodes.add(new Node(6, "2-1", 2));
        listNodes.add(new Node(7, "3-1", 3));
        listNodes.add(new Node(8, "1-1-1", 4));
        listNodes.add(new Node(9, "1-1-2", 4));
        printTree(listNodes, Node::getChildrens);
        // 聚合
        List<Node> treeNodes = polymerizationTree(listNodes, Node::getId, Node::getParentId, Node::setChildrens);
        printTree(treeNodes, Node::getChildrens);
        // 平铺
        listNodes = tileTree(treeNodes, Node::getChildrens);
        printTree(listNodes, Node::getChildrens);
    }

    private static class Node {
        private Integer id;
        private String name;
//        private Integer relationId;
//        private Map<String, Object> relationMap;//map.put(relationId,)
        private Integer parentId;
        private List<Node> childrens;

        public Node(Integer id, String name, Integer parentId) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public List<Node> getChildrens() {
            return childrens;
        }

        public void setChildrens(List<Node> childrens) {
            this.childrens = childrens;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
