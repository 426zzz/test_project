package org.lyz.test_project.entity;

public class UserInfo {
    private String username;
    private String nickname;
    private Integer tel;
    public String test;

    public UserInfo() {
    }

    public UserInfo(String username) {
        this.username = username;
    }

    public UserInfo(String username, String nickname, Integer tel) {
        this.username = username;
        this.nickname = nickname;
        this.tel = tel;
    }

    private UserInfo(Integer tel){
        this.tel = tel;
    }

    private void test(){
        System.out.println("test");
    }

    private void test(int a){
        System.out.println("test(int " + a + ")");
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", tel=" + tel +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }
}
