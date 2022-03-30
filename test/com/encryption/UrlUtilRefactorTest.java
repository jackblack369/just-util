package com.encryption;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class UrlUtilRefactorTest {
    private static final Logger LOG = LoggerFactory.getLogger(UrlUtilRefactorTest.class);
    private String key = "eyecool_campus_bio";
    private  String imgBase64 = "_9j_4AAQSkZJRgABAQAAAQABAAD_2wBDAAoHBwgHBgoICAgLCgoLDhgQDg0NDh0VFhEYIx8lJCIfIiEmKzcvJik0KSEiMEExNDk7Pj4-JS5ESUM8SDc9Pjv_2wBDAQoLCw4NDhwQEBw7KCIoOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozv_wAARCAGdAScDASIAAhEBAxEB_8QAHAAAAQUBAQEAAAAAAAAAAAAAAAIDBAUGAQcI_8QAPhAAAQQBAwMDAwIEBgIABAcAAQACAxEEEiExBUFRBhNhIjJxFIEHQpGhFSNSscHRM2IWQ1PhFyQlNERjcv_EABkBAQADAQEAAAAAAAAAAAAAAAABAgMEBf_EACcRAQEAAgICAgICAgMBAAAAAAABAhEDMRIhBEETUTJhIkJicZGB_9oADAMBAAIRAxEAPwD2ZCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCEIBCE3LKyJhc4gAIHFwuA5KyfWvXOD07U0PBcOwWK6h_FCd5IgbSja3j-3r5mjH8wULM6ziYYuSVo_deJyfxD6o4mpCFTdQ9R9Qz3XJM6vFptaYx7w31b0x3_8hn9Vxnq3pr5dAnZ_VfPX6zIA_wDI4fukszchjtQkdfm0TqPpM9cwQzV77a_KjH1T00O0--y78r58_wAZzy0t_UPr8pk5-TrDvedY-URrF9OQZsGQwPY8EH5TplYOXBfPeD626nhxNjbKaHcqbL_ETqbwAHkJs8Y94a5ruDaUvMfSfr9krQ3Ok0k8WVvsTrOHltBjlab-U2rcbFghJa4OFg2lKVQhCEAhCEAhCEAhCEAhCEAhCEAhCEAhCEAhCEAhCEAhCh9Q6hFgY7pJHAUEC83Mjw4HSSOAAC8t9V_xAe5z8fFd8WFC9X-upM1z8bGdTeLWAe98ji5x3PJULz0cy82XKmL5HlxPNqPe1FB8I5QA2APlB5s7hd0rmm3UXJo2SXOc5KIsb9koNGkpA-p1A2Ap0grY1ta45v7eV01QA7LoP1b9_KBNfOwXDf3Fddzvwujc0idgPe12oOI8Kz6d6hzsGQOjmdQ7Wqsg8LunsoTu7ez-j_XTM5jYcl9P-St_FMyZgcxwIK-XcXIlxZhJG8gjwvQvSn8QZIpGY-U41xZKFkr2RCiYGfFnQNljcCCFLUswhCEAhCEAhCEAhCEAhCEAhCEAhCEAhCEAhCRI8RsLiaAQR8_Oiwsd0kjgAAvG_WXrKbPmfj47_o42Ks_4hepXumOLBJt3peavkLnEu5Khfol7i5xs2e64DWw2XDewCK2ofuVKHOeF0bccrpIHHjsirFBBwnfbj_dcurTmgA_PCSB5RDh7eUVQJoJRCNFj4QIAJ-Albdt6RQ48IA42QI53Pfhd3rZdq3fCUNncbIObEf7pOohK3soLbA2RLlbWO6I3lr7BohFkfKCACPBRL0X0H6tkgnZiTvtp2BK9gglE0TXtNghfMGLkvxclsjCQWm7Xufof1HH1LAZG5_1tFFQX22KFxdUqBCEIBCEIBCEIBCEIBCEIBCEIBCEIBUXqrqBwOlSyNNGleFec_wATOr-ziHHB-7lFo8q6nmPzMySV7juSoJ525S3fUSUBp5pByqHPCTtVn-6dEYFars9l0s8CvyiDO5opTWg7lOe325_CVpe43QCBOkAeEnTtdp5sThsSle3vuD_2idGGi_hLa29u6ccw_aNiV0R02_5lBoyW1uQk6Se2ykFgDQTyk8O8hSGPbvuuVXdSTGLBJ5_suPiaftO6bEeu9rujhLDAOb_6Sw2t6sBAwWGkgn4Ugs1A1d8pkjcjwg4exHhaP0f1p_TOpM-umuKzlWCEuBxZIHDsUH0307Kbl4jJWm7ClrEfw96v-s6a2Nz7c3ZbdEUIQhEBCEIBCEIBCEIBCEIBCEIBCEIEvNMJXif8S8oy9T9vwvach2mFx-F4H67n93rcgHINItOmYFXvsE-xjjQaNzymoQDIAdwrSGIPcImD6j_ZSdmI8ZxFNaXOPKkR9Kne2ww_nytNgdMayJtt3733VnHiM0UG7dllc2-PHPtjY-iTyEWNvhWOP6ba4fUT87LTR4zR2pPxwWduFHlVvDFmz6eYwaYmWT_Meyiy-nw0OaC5zhyR5W5Zj7bhcdiCtmjdN01HnMvSZYj9JcXkeOEw_CfHGC7v5Xon-Fxklx7_AN0zL0aGUURanyRcI8-HT55Bqaw0nIekyuYX0RQ_ovQGdKiazSGgVyhvS2NH2_NJ5onHGJxvTk08QedrFgJ5npuQXqP4W5iw2RNpoFLrsVvNKPKreEYb_wCG9O7iXJL-guZHx-Ft3QAcBNuga4bhR5VPhGGHRnW4iwa4VRPjOjkOx_ovRzjNBLS1Ved0qN7nPLNgOymZK5YTTBUQ4g8JIFf1U_MxfakcOCOPlQSNzS1c99Nv_DnqLoOpNhLqa7svbY3aowfIXzj6bzDidWhff8wX0J0ucZGDG8d2hC9JqEIRUIQhAIQhAIQhAIQhAIQhAIQhAxmf_tn_AIXz56wN9bmH_sV9B5YvGf8AhfP3q5v_AOuTX5RadKWAU75OyvOixNGQHO33VNE3S7yR3pX3R2f5rfJUXpOPbXRD6RtVqS1lNvymoG_QFMaymrB1mmsrspEDN0nSQaT0Yqtt0h9HgKXdNhKY4EJdWNgrKI-g-KRoThabSTd7KFiSygkaeKSzqKACdlCQGb0le3adYyh2tdIpW0rtDewDsmTHyQpsje6ZLCDahMqIWb7jdR8mI-075Csns3Ci5DAWOruoS886uwNmcNPyFSyNAOy03XIKlLqWfmj0uAB_creOXOeycG25sR_9gvob0w_V0iE_-oXz7iMvMjv_AFBfQXphunpEI_8AUKVfpcoQhFQhCEAhCEAhCEAhCEAhCEAhCEDWQNULh8Lwj1rB7fW5D5K96eLYQvH_AOIPTzH1H3a2ci06YeFg172tH0WK5WkBUcEet_x4Ws6JiH7iNh3Vcr6aYT2v4W1SksFkFMM2T0bhaxdJwtHdLFClwfVylKVTjSPhOtc0DcpltkbIs3RKlGjji3m02V0ixVI0lKQldCHNK5RChJ0yUKXNVpuiUoNoKfaNOk-Emr8pX7IBCBqQVuo0o5UmTc0mXNsqExlet4lA0LB_ssnksLHURxxa9I6hiieAivqCxPVcT25CDsRytMayzirwGk5jARvqC-gPTjS3pUIP-kLw7omP7vVImnu4L3vpcXtYMbfDQrsfpMQhCKhCEIBCEIBCEIBCEIBCEIBCEIOLAfxGw9eJ7oHHdegLNetIWy9IlvsEWxeNYUWrIDOLcFusSIRQtaFjOmi-ptHhy3DR9I-FlnXTxw4EoOpNgm9lCzc0wOIAt3gcBVk20t0tWztDqLt0-yRryBYWNdnZ0ji9jX0dga4Tf6jqbw7RK5vnZazBhcm9a9u1Ef1XXAduVg4Z-ok0Q51HeiVb4k-Sx4t768FNEtadrdvnwgNs2m8Wa2NJNnypJICjS2yCwVaaO1k1V7KQSK4UWdp7HlNGyDlQMP1ytBut04MiAjaVh_dUedhzvDi0iwdj4VHkYWSz7GPsd73KtJFba2xkjJ2kaR-U0Z2XWoFYqFnVgSW48jmDmjSlRSZwcDJFLHXchLiiZVqtYdwbXLtVeLkz6wH7tPelaNG26ys01lJeAQsj6lia2QOpa-QECwLWY9UtIiY4DumPaMukb0XgHJ6u1wFtBte1QM0RNb4C8y_huI_ccTVheoDjZbObJ1CEIqEIQgEIQgEIQgEIQgEIQgEIQganlEURcewWG9VZ82b0qY4r9WkE0Ft8pnuQOb5CxLsctypIzsNx-VXLbfixllebdCcZOptvY6t7W_ibbVlT0v8Awv1Q2Nu7JQXN-FroG7BZ5dtsJqEBm5rt2QMZjn6jVjsQpWkEKJkSjGBJtRLo7SGYsfBaK7p8YmNp-xpVHD1bJysr9Ni49uH88hof0UTq_XOpdJzpMfIlx4Y2xa2OMZd7juzfj8rXGZVnlZO2ifiQtOprRaZkiDewVL6d6vm-oNEbciAZAY508IjI9mj9IvvatIsiQ5UmHMzRPHyOzh5CrljlFscsb0m47x5UwO2VZCHMloirVlEwPHNUolTS2u23TMrw0HdSfbAGyg5LS7hKiGi_XdCguxxxXZFlQ8uV-MxrWsL5ZDTI_PyfhRuuQz4GBBlzZOSIzfvDFA1A9q-FOONpllMV_Ho7t_suSCJx3AXn_p_Pzs_LixWZuc7LfMS6yDGIv-_K1PVJcvAnDMeVmT5jI3H7q9xsnamOUt0sH48ZN6R-ydDNgFBw8x8oAlidG4_0VgAA21lvbTWjUjdlmvVbCMAPH8p3WodwqL1JC6XpUrWiyapJ2nuIHoH3Mdk-bI4iMmmt8r1fp85nxmvIIsXusF0HA_RdJhhcN6vhbzpzdOM0fC0jLkkmKYhCFZzhCEIBCEIBCEIBCEIBCEIBCEIEvFtIWV6rD7WU5wHItatUfWYLBd8FVya8V1WCz2Ol61BkO-rSKBHZW2OfpTGREHQul4LHBP43FLLKOy60lNq7KJYWyt3CG9k81tpGVVh6cwncFpB2e3YhM9R6V-vha3K9vI0fY92zmj891ftjBG6bfA2jsrzc6R6vah6bjO6XE6DFDIQ_7nsbbj-6lY-E0zNne6SSRvDnuVg3GBdtsE8Ygxqbt7PU6QntOsE9lKxyU05up1BPQjTsq_a30fN1yor_ALlJ5aU09m_CIRMnFjm0uey3Dg3uFEdE9rDC172xu5afqBVu1oIorhgHNKx_2qcDprMTWYn6A_7tDaJ_dTG4cQ3jZRPJPKmMib3Cd0gDZPf2jrpFZA1reN_KURtSfLQU25tcqNBhxpVvVWmTDexvJG35VlJt2UPIq23wXKF4k9HuWGONxtzatbPGbphCyXSGj9Y4tA0_C2EW0bfwtMWPN2WhCFZzhCEIBCEIBCEIBCEIBCEIBCEIBQ8-H3YTt2UxJc0OFFEy6rzzquLLD7haRo5IScVwLQVouu4OqN5A5aVl8B30gHtsscp7d2OXlitWBPxNTLDTU-x1flTFKkBtN-Ug80V0W7hBFqyrmwCakdq_ZPadlGyJmRclQmOAULPKcjUdk_ucBSIgd1CacLuyRd8pZoBMSOLOyB1u58JaiR5LS8Nca8WpTTe_lSO0u96tdrZcpSgqgmn8JbtuCmnuQhiTwq_JbrIZdW6rU-QqGxvu5UYrYuVF4v8AomCIwCAfklaNooAKH0-IMiGymrWRyZ5eVCEIUqBCEIBCEIBCEIBCEIBCEIBCEIBCEIImbje_GR8LDz9PkwchwI-nUaXoSouv4wdEXAKmU224s9XShifY-FKaRtSr4TvpPClxkhwPZUjerBhaGrhe0nbhNNcaXCVfamipH0wlVDLycka-LVmaLSK5UWbGIAdE7S4cKO1p6POZHEGjUAfFqTA-PSdW57LN5vTf8Qy2OyjI0s-0xuIo-VPilmxWhjtcgGxeeUhYuWGPQ4u-7so7nw6g172tvizVqCc6QsIZHbjwFWv6HHk5P67Lkklma62jVQb-FJJ7W-fC1kReD-67hSOdHTuR5SGxyTBrZTTG_wAvlSNDYwNA2Cg39Hw-9l26CY1GrShJeyShZI7Jl7rd8LrnaeyQTY8IGJjQIJUzo-D7szZHdlBeC80tJ0OLTEDSie6jO6xW0bAxoCWhC1cgQhCAQhCAQhCAQhCAQhCAQhCAQhCAQhCAUPqUPu47h8KYo2ZkRQwOMjgAB3RM7YmSP25nDjdOMd_RdypWS5BcxwLTuFwfTW-3ZYuz6SGPoUu6haaadl0urYptB1zw0WUzJJ4opp8h7nZN-4NVXsrRFKMjhXG65qc5wPAXT7bG6ncdkhszHWNTQOybTq0t30gkf0XY5NIH-yQLDrc4funGFkgrZNlxpbJg6zwE82QVRUQgMcfCQ-ehTTv8ohN1VwUBwPChsnLjupLW2dVKv2sc5tJcOyL7LpUqkNbbh5Wq6ZHoxx-Fk3TNidqcdhuVY9G9XdPy2iNsrQQa5VsVOTpqEJEcrJWhzSCClq7nCEIQCEIQCEIQCEIQCEIQCEIQCEIQCS5waLJoJnKzIcSIvkeAAO6859U_xCbFqgxHW7iwnadNb1z1Vh9KhcXSAuHa15X6g9d5fUpHRQPLWflZvqnVMnqD_clkc4n5UGI-e_dXmOqbb70d1d2Xjuxp36pYDtfdpWtbRbsvIukZOTidUjycZjnaNntHBb3XqGFmR5EDXsdbXCwsuTHV26OPLc0nsJ5PKW8arKYa_wApbJNzZsLJojSNLSSd1AlyMhklwwGQDdwtWsjA82BaSIRH9Q7qYKCTOyJ3DUx7R4PZORzucAAHD8hWGTitMnuAbd_hOxxRGP6S21eaaRB96Q9ia-E3LNkagWAg_lWrWN1U5w0pM8cZOljAnpNVwzs6YaGRNc4fzE7BLY-Wy2Zn1dyOFY48AisCrPIS347ea3VKzRsV5fJo0mh3VmDtQ2UVjQx1AUn2uUIpQ3Q51blGoCyo2TksjY5znANAskqVVD6u6sMDpUgY7_Nm-hn_ACvPYs-bEkY6J5aRuaKsPVGdN1DqZL7bG0VG3tXlUg3eAR3XRjNTTnzy3Xrfo31tqbHj5T9z5XpUE7J4w9jgQV80QzSRSCRjiCOF6V6N9a7txcp_7kqcsfuK729SQmcfIZkRB7HAgp5UQEIQgEIQgEIQgEIQgEIQgFD6lnx4GK-V7gA0WpTnBrST2Xmn8QfUB0nEidzzSmTdT_bNervXGRnTPgx3kM3GxWLe98j9T3EnykzNcJnXzdpIJJV56RvZcp-0D8qx6d0gzNEs9hvZoXOnYYe4PeNRP9lfNfHE3TYBA4tWn7RUJz4oSYQwRNr6T5Vh6ez5Is1-Kd4y3XV8Km6jKwyWDbHbEeCpfpZj3dTlc42Y46B82s-S_wCNacf8o3kcuptg8pwPOmz28KrDzjna_bP9lMinDqN7LmdabFIHtsAhO6tqCYjc0p8DdEGXR72DSjS4rnm7A_8A8qyMYO4XDHXbZTIbVAxpB9JLvzakwxPZspojB3_4TgiDhfFKTZhjdO3dOcpbmgJANHdVNmpOduyA6giV4APZRJckMBtA_LOGNO_7rLeoM6Z-iNp0xO3vu5Wpc7KdvYYDuPKofWLXNixntdpaHFrqV8PWUUz_AI1VZH6bMZ7MxAcB9DxyCqWbHfj5PtyD7d78jypEGVoyGNhaHEmrKsursb7uLI4AawWuK6e3IqCeBynY3OhcHsNOCcnxHY9PG8Z4Kjl57C_hX-kPSvRXrMjRi5T9-BZXp8EzZ4w9hsFfOGGX40jZQTr8-F6t6L9TCeNuPM_6h5WeWGptaXfpvkJLXBzQR3SlmBCEIBCEIBCEIBCFxxppKCn9RdTb0_Ae66NbLxHqua_Py3ySWbK3Xr7qtyew123defuDXXvuujjx9bVzv0q8lt7jcDZNMjNNNcqVM2g5p4PClHCIxmO4obquU9plWeE5oxG-20Cgkzhs9F7SCOCNiEjp7g1mg8jsrEU4HYKfpDL5znMcYnHUOWv4v8q49EPdLlZbSOGNoqs62z2iHltb7LReksL9JgiQ7SSnW4rDkuo345_k0TWhw0uGyYkidAbabYpoZqbqb-9II23Gy53Sj4-ZoOlx28qziyA5tkqqnxeXRix48KM2aaA_SbHyrIaVs4AonZdMzeatUDOpW3TI0j5Tg6i0UAf6q0itq6MwrbakDJ35VN_iAdxwuHOA8p7QuTNe_jymJstrQqh2dITTdgkt92V3fdRpKXLllx379gm2ROmOp32pyDErd25UsRUFG0mQwN2Cz3rZg_wMOrcSBacsoX2Wc9ZMdN0OQN3pwKY_yiMv41i-mNvKaRyrL1DthwUfqD7Cr-jtLs4NuqG6tOuts40R7uC68enJUjFgM3TtLhZI3VTLinGlpwvbYrTwRiOBoA7KNmYrchpHBA2V8fStUTGlxGysen5z8HIY9jiKKhbssOG47IL1so9u9Mdcj6jhsBeNQG60C8P9Mdak6bltLnEM8L0SX1xgRQtuUBxHdcmeFxrWXyjWLqruk9SZ1DFbM0j6hasVQCEIQCjZmWMSIyOGwUlMZLYnxFshFHyiYzknrrp0T3NdJRbyoWR_EDBfE4RvDiReyzXrnH6fjvcA0OD_ALi3YgflY2o2uLoWu0Hi-aWuGEyRllpY9Zz3dSzHylx3OyrgOeV38LhsCwuqTTI1KwOcO9kK-GO0RgUOO6p2gPlj2_mC0vJrtws84tjVDNE7HfraKLefwrHGf7jWkcHlLzscGIvaBtyovSnFzC0G9LqWaai-osf_APK66-1wWk6M0HDiruwKv6xAJunTM76bClemJvf6VCb3b9JXPzR0cNX8YI45ThaDwPyFyMbXypDWAm-_lYt0Yxg_8KNNitfd7HyrJ8Pcgg-Rwo8jXNuwgqn4mn7hQ8pH6ffkq1IaduPhIdjhxvSP2U7Ff-kvl7v2Shitvck_kqaMb4P9U9HCGmw0BNmkOHDs3V_hTosdraqj-E5WyW0VyoHQwAILQBuljURxQXC0lEGZAar-ypOsRibFliO4LSruYhrSAVU5bbjkcf8ASUSwnQmk9Sex3LRyrDq419Sx2-HBReiDT1aY9tJv-qlzj3urQUf57XZj04r6q6I0xAHsEzGLdzaen2aAOV2GPb4V1VP1bGEM4lYKbJyPlQGj4Wg6vGD08n_SQVRAbLbH3FKG2DskZPuEMcLcNQBF9k6E43TYLhsDZVrPRO2-9BDPbALDxFf06jwF6I29ItZH0N1CCfAaxjga4WvXBbt0ZzxunUIQoUQOpdTh6fA6SR4FBeY-ofXc8sro8VxDeLCq-veqp-rucxjyAOQs46ybPK3w4_umd8b4pE-bPnykzvJB3NnZJpzRbTbfHdEbab2s72l8bkhdEmmNpDTYSuyNLbsFK5UhAIa9rvDgaWpDQ4B3xayzmggiloOm5Pv4DCfuZ9JVM59pxp6VmqNwI5FKk6Y4wdQkhd3NhaHSdPyqfOhMU7chjac070sl1lO0Phc0jYilW-lZ_wBNmTYUhqzbfyrOJwkiBG9hU0kboeovlj2ex9j5WXLPTXivtuYjQUuO1W4OS3Jx2yDkhWDDQXNp0Hx-UGNju1IBsBdu0EWTDsksI_BTQxpmn7VNJKT7h4IRMqII5b3GydbE_uE-JCO9JRlNcondNtiPik62NreBZXBZ3NpfHKKkutNuNA7p0kDhR3GzVoGJAXHdVvVHe1gyu_8AU0rZzb7Kg9Ry1B7LTu5JE7ZXo7ayJn_Cn4sXudSDq-wJvp8BjY95H0uNA-VaYEAjLn1u5deHTkz7Oyss8fhOximkoItyXwFoz2r-rO04JHOogBUdhWnWpNmRA2eSqrvytsJ6UtAOyVyPCb71aUXXsD_RWQtPT3XH9GznFp-gkEhetdD9QQdUgBDhq8Lw2WxVCz3IVl0Xrk_TMgOa46QdwsM-PfuNccvqvegbQqD0_wCoYepYocXAOre0LlvpfVeDEODtQJBHCsOn4U3Uw4wNaNHJdsL8KJCx2RKyGNtveaC2fT8SLBw2Qtbq7kjufK9Pi4_K_wBOLn5fCf2y-Tiz4hrJhfF4cRbT-6Z1Vy0EeQtqYtTXNeQ5juWO3BVTlensd9vxJBA_ksO7D_0tMuGzpjh8qX1kohpPBXdQA3IXcnCycWTTPCYh2fy134KSIW8ndY2WenVLLNwkvvZoseVL6dknEyQ5-0b9nfHymAAOEV53HdLNp21YojlNzwCVhHFqr6Z1L2w3GyD9HDHnt8FXQOw4I-FhcdLyokDHY5DHcDgpvNxw4idnPBU17QU29g9pzR4Wec3GmF1TnR5dEntE1q4_K0DHEHS8LKwW14cNnNNrV45E2O0nuFyuo63cbFK17gHlMhj43bHZPintpwo9lGgr7uFwxWlsaK2TgbYtNG0X23BdDT3UnRtuuaE0nZrgIKcLaSHAKNBs2k6N06Gk8Bd0bKdGzLgGsPwsl1M-9kPPNbBa7L-jFce9LO40BlnMzgQyPcuq6KtJu6V3qbQpsb2mwQAAaW24g82pEYAFcJM8mvIc7aydyOClRNt1k7BdcmnJbs5s0ElNSSaGOkeaaN0pxBJc400eVSdT6iJ_8iG_bB3P-pXxx2pai5E7sid0pPPH4TST9LuDRXDrHgrZUd7RqHYgBJazUd-E7j45yZPbgiMju9cD8lTraLZPdNgg8E_lO_pMk45yBjPLBya5V7gdFhhqTIIleOGgfS1XAY5za_lIqitseHfblz-VJdYsZg9YzMMkxSFt9vCFadV6AA73MQAf6mE7IWOXBlvp0YfIwym9kenumCGP9TKP82QbA_yt7fuVeuaedQrvpKRFjRxs_wAsbO3vyg4_-mwu3HHxmnm8mfnl5OloHivKNuA0EIp7BTi1w8FNulDfuDmhX0y2dcGvYY5GhzDy1wsKryvT8brfhSe27_6T92_seysmSxuAp9pwAHvarcZl2tjnlhd41j54JsST28iIxu7E8H8FNlbWSKOWIxzNa9h5Dhapsz063d-DLX_9Tzsfweywy4bP4uzj-VL6y9KKgXUpeJ1KbEOgf5kX-k8j8FR5InwSmOdjopB2d_x5XBvdLns-q65fuNLjZUGbH_lP38HkJ0fWK4IWVaXxyB0ZLHDuFd9P6kMo-3LTZ28-HjysssGkqWGAutaHpVnH0nsqlmP7rNcZ1OAtzO7flWnT_piXFyYXDK4114ZzkxmWKx0_0SgwBIYXAeU406iFRbRXti04GnzsgLt-FI5pK4Wnsl2uXuiSCz5TTXh8jgGkaDRsc_hSL2SHEKBwCiuOIbuQuFx_lCjSTOdJ7UX1ynb4b-UQbz3l7RBGLkk4b_yq_JbHiwmJjiQzlzeb-QriHDbCwlx1yu-9x_4-FR9TfUjqOonh47jwV1cXHbf7cvLyyT-lSwanlx5vhLnyosOG5XUTwO5UTK6hHhgxsp0vYdh-VTySSZEpllcXErbHDfamWR7M6hLluI3ZGP5QopLhx9Q8JVBp-Si7HPC1k0z2TqBHCS57W1bjZ4FblSsbp2VnOHstDGHmR_FfHlXuD0zGwgHNb7k3eR25_bwtceO5MOTnxw9d1WYPRZsge5mXBHyGD73f9K8hhhx4hFBEGMHZv_Kc0lxslOCJ1XYAXTjjMenBnyZZ_wAqaFgfSxLbZ-8ub-6ca2uAuGidNbhX0z2aIebAJLflCfbdGwhNJ8la6fKwpQ6NomxHXY_miP8AyCnoepQzkMLvbeWg6XbEXws1geoJIGiPJDnhooSN-79x3UnI6106Zl6HvJILmaK1EcC-yznLhZvba8GcutNLTOQbKHEEVpCzmLnzGIy4j_fawXLDIac0k7Nae6s8PrGPkOMRJjlaadFIKcD_AMq0u-lMuOztKfjxONBul3lqbMWRAdjrH91JEjXcVa65uof3Vts0dmQD9zaPypDXtcNiE09gk-l4sFNuxSw1G667FShIyMXHzIvbnja9vg9lQ5vp-aC34hMsf-g_cPx5Vu2QNOl4LHfPdP8A1Deyf3VMsJl20w5M-O-qxhG9EEEcg8j8oYCMmLSadrFELUZ3T8XPFyNMcoG0ref38qnj6ZkY_VMeKZlsL7bI37Xf9Fc94rLHdh8jHKX6rSMjeyRkjDpe0bK3xXsyhq_8cw2v_wCofwq0buTkT3RSh7eRx8K_yOGcmP8Abm-L8i8WWvqrlts2kbpI2scJ8N1DaikwzNeyxRLfpA7X3XQwanahQHdvleNeL9PdnL-yuOF0JFOaTb7AF3SV9d1baq1TwyX_ACYun8IopLtXntfCBG55rU66tT-PI_Ji44CtzSbL2t4tx-AnWxtaQHDUSu6S2uK4KmcX7UvL-kd7JJAQfobVkA7p2KFkbQ1jA3vt_N-U5wKO5bxXhFfQT2-ey0mMjPLO5doufM2GHY0T9p8KgLRI8vcANXZS-o5gnnMbDqbVE9gmA2hZXpfG49Tyryvmcm7MIxvUcZ2L1CWI8E6gfIKYG21LQ-oMQy4zcuNtvi2cByQVBwuhyzAS5pMMZ4jafqd-T2Vs-O-Xppx8-P495VWxQzZU_tY8Zkf38N_JV1idEhgAfkO9-XnT_K3_ALVnDCyKMRQRiOMdgn2xhv5WmPHJ7rn5PkZZep6hlsRoDgeE4IgE4KugL-UlxDe9nwtdObboAb9ospWnuTZSWggW40h8scQtz1OkFOJH0t-7_ZcaxsbPqO6iuyZDqdG3Q3lz3ePIHdRXZDSS1odkybguJpvwQpTIsTkMv6XDf90KNHHkzC5XNZZumCt6pCjSf8WCLS08IH5Ul0YITemjRC8vT2yWPdHK2Rji17TbXDsVNHWGujDM3GE-lp0yN2cXE_cSoZbaYlabVsc8sOlMsMcu2kxcljyBgZ4eC4NbHPydtz5Cs8fqJAH6pjogRYcPqaR5sLEtbf58p-HNy8axFO4NIDS07ivHwt8fkT_aOfL42-q3keTDO243td4IKdvvysbF1LFyX6si8Gey734ft24bXdXMXVJ8IBnUGamEAjIi3ZvwD4K6Mcpl7jkz4rj6XGkPdpc22nkJswmM3C8t-DuERzMlj1RyNcD_ADA2nGOY4bElXYm_dAIbM3QT37FOaCG_S62nseEoaXbOoj54KQ6P2zqgeGj_AEHcf_ZAkPcw_wDBT0UrJBsfyE2JWyfRI3Q_sDwfwU1LA5r9cZpw_umzS76bkNaRA40Bvv3KtGuJAOxF2QsxjTte5usUW8rRY5jdENFmu_C835HH45bn29X43J54avcSA7Vq203yhzfqdQ7crgGnbUSUsh2m7BK5nUb1EVW9hdBdTSduwpdstGpxA80kb3tf7lAo3pIsCj53QHXe6T9BO4_O6WAK-njv8qAkB3NA_lRM6UsiLXE7_HCnfS01z3OypOpTGWTRf7fC048LnlJFOTOYY3KoTbc4vPfj8Lk0rYwG1bjw0JEuQI_pZRd_sm44nvJcTzyT3XsSTGaeHbcruuhxcbJ1O7VwEtsZJtycaxrBwu053wERtzjhGn_V_RLA08C_K447Gr3RBt7gG0DSjGch-lgLq5J4Hz-FzLkLnCGJuqQ-Oyb1iJhZE63EfVINifLSFZaT7pU2U1hc18hc8WC1nAPYg9wmmZE8r7igZHuHBx3o_HwuRYmoh1UPCnRxgD8J6N66RP0bpSPdkL6Ow7D8KXDjsjFNACdaB4SgFG0e3WgBCCEKEMAkloPZKXF5z3XNACbcwEp0pNFQGjGm3RkKSb8bLmkJpG0UtPhSMPqWT091Rn3Ib1Ohfw48Lvtgj_dJMQI4SbnuFks1YtsTOwXEHHmdhymgWEfQ9xO5rwFbxZOaG21kM7HF1OjdyG8lZD2QeQue05huN72dvpcQuic917jmy-Pjeq2Y6gR_58OZgoEmr54_qn48vGf9sjmG60uFb-Fixm5zQay5Txyb44_ouDq_UQ-zlOJ1F24B3PJVvz4_pnfi36rd02ZtamyNK40vZ9N6m_6Xcj91jIes5bKa8MkbQbt9JoeD5Wg6d1U5cZMJDiy3SQyGnMb2DT3KvjyY5dVlnwZYTdWZaCdTeVbdKzXBhjNEt5tVEEsWWzVGSHD7mO2c0-CE7G90Mwf_AF-QnLh546V4c7x57ahrw5gLtN-F0vLQOFChyYtIB2vgqXHJG4UXC_C8qx7G3Wvs0XbfCULII2I-Vz6QeD-yU46SNj-yhLmrQKJFfARqqtO_5C6dJZx_VcdK1jbdRodkDGXMYoHOvt_VZmbJdJIdG5PfwFYdUyy9mloA1_KgQRACyvQ-LhqeTzvl57sxEOP_ADOHKkktb-EjX2buUlxDGl8jqC63BaXq8IBd5tMifWC4ANYDpLnGgD8qM7PDrDXl3wwcHuCpNLAvA_8Aso8s4bYB38BRWOfMSGhw3O5P9E8IX9qamj1DRjc1xa5tSH7v_U-QU9Djhv1O3PynY4Q0Wd0ruha7oGlcbQ2SwdqXANyUQAEoIrZCgdQuWhEsBYRYRa4vOe46eFxd7rh5RG3EbrtJcHtfqYv1F-zrHuV4UmzmD0_M6nK-Hp-K_KkY3U5sdfS3yVzNwczpjms6jiS4bnC2-8KDvwVqv0k-ZBPh9BLf1JZqPsyhlR9wT3vwrj09juh6bj9J9Qvjycxr5MmLGmeJXQRBtfUfyeFHJLhVePLzm9aebWLqxfi910hbtnp7CzOixRw9IiwZDp_US5QIlj1u2lY8fS4f-qjDoHSszrkvp_G9P5eH7Unt_wCLPebsC7IOx1dlTzjTxYssHhR5YjyOVucPovprqDM2UYGfgY_TclsUsmRKayQTRAvg34Sv_wAP9U-XjyZJhmfM5vT2k2PabzI8d_AS5T7NVhIpfafq9sPaRTmnupUDzFI3KwnO1Rmy0_cz_sLQZH8P8z3cX9HlOfHkTGFz8iH2zE4C7ru00qTM6F1LpEE-ZLLjEYsoikMEmssc7gH_AK-VbHP6VuK8x529RjOfhAjMb_5oRu6c-f2VrBM3IiDrB7WOLWRH6zpnUQ3T-iz2tDnQ6tntO-x7X4V7hZUOc4y4oMMzR_m4xNBgHJ-V3cecynt53NxXG7i-xJXahC48cK0jf7TRqIPhZ-HIDtLgSCNwSKI_ZWcGQZtzpLq-0f7rl-RxavlOnR8bm3PC9reOTXtdnwlEFtbbqujyHBtaD-GqdDMHiia_uuPTt2W7UGXYH57qvyJXPJIIb5S-oZJaPba7buVUZc4DNLOX977LTDC5XUUzzmGNtNTSnImuhpbsEoCx8JuNlj4CHztaRHENchNDegD8nsvVxxmM1Hi55XPLdLllbjxlzuewHdQ5ZAypsn63OFxw9nN_PYpt2S1k5Af72WDX08QOH-6ViYxdO-aU6nuO_gK2jWu0eePIzj_ml2mq_btflTMaGOBga2M_05U0NDRwF2w37iB-U2rbajOx3Ee4y2u8DuusdJ3NKVqP7Jt-52TaHQbC6W3wkgdqSggRZad04OLAXHAObuuNJAomz8IO6ux2XC4AHfYf2ULqHWcLp_0Sya5jxFHuf38LM9U6nk9RAaXe1Af_AJbDz-T3WeWcx7b8fDln_wBLrM9RYsDzFjD9TIOSDTR-6FmoWBraAACFhebL6duPx-OTVmwN1xdR3KwdAB3Xf7LgrwujhSOnbuuUF2qSbpAfb9pc35aSP9k5iGKLMifMZPa1gzaHHU5vcWm7tdHlL1ol9rbI6hgzdOzcXXOGGUHCgc5xZE3vtf70pWb1zEy43xnOzyzFib-ja-V31Sj-e_jtaoO6Csvxf8r_AOtPy39T_wAaDqvVsXq0WNDm9UychsUJe8fa18wH08d7SJOs5Z6jD1dvVzJmY2G0H3WgscSaMVDt57qiI2C44AdknHZ_tS8m_qN9BN1ODquMYsPEkazGkeIoZXNGpwrVvew7Kn9L4buldP6pn9Wwx_hrgyeN73D_ADp2uOnSOTvXKzkc02O7XBPLG6q1NeQa8fhNmy2i5xF3pLjV-a4TDDOesrv_AOGWeN_jNGcyafNzJsrJJfLM8vdfa-yVFlODm-65wLPslb9zfz5CUWg89ky9g5Wstl3GVm-2hxuvG2s6gB9e7ciPh48fCuMfIfGPdbIJogNRe3lnx8rCRSFgew_VG47sPH5-CpXSeqZGJmtjYbjLqDSeFvjzS-q5c-D7xekwZUUkQe4kbcjumH9Ujx73FXvaouptL-lylj3RuaBIS08kFU-DlT5EIM0hf3F8hc_LxzDJtw8v5Md_bbHKZOdTzZ_sFXSyB73PP23sB4UDCy5HtMZqhsnuo5Tun40kkQBewbE978rf42HdYfKytsxiQ-Qg6JDx_wDLadyD3tRpxkSsMcf0NcNLiBWofPynel4gjxGyPeZJZfqc93_HhS5GgN2XY4LdX0gYeJHhxaWC3u7lWULPbZ_uUw36fq7puad77aNmjt5Qu6flygPpj3PlRnOLzZOonyk1W3lSMeJsjiDwOflT6hoYj3tcWkfSOLUl7Ddt79krQ1jaaEzlT_p4tenVQ4ulTunZxpczkah_cJdir7eSslkerMn3DHDBHHvVk6lFnzsvLH-fkPc0j7QaCzy5cZdOjH4ud79NPl9cwMO2ul9x4_kj3Kos31DmZVx4zf0sZ7jd5_fsq4MA4FLtd1lly5Xp1YfHwx_tHbFpcXblxNlxNkp5p7VshzbQwapNN18rF0FgVtwhOPiLBZdf7ITVRuP_2Q==";

    @Test
    void enCryptAndEncodeTest() {
        try {
            String encryptResult = UrlUtilRefactor.enCryptAndEncode(imgBase64, key);

//            String isSuccess = encryptResult.equals(imgBase64) ? "Success" : "fail";
//            System.out.println("Result:" + isSuccess);
            LOG.info("encryptResult:{}",encryptResult);
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
        }
    }

    @Test
    void deCryptAndDecodeTest() {
    }
}