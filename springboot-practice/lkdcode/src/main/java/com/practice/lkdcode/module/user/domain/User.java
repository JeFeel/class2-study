package com.practice.lkdcode.module.user.domain;

import com.practice.lkdcode.global.common.BaseEntity;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.user.domain.status.UserStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_user")
public class User extends BaseEntity {
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @Builder
    public User(String email, String password, UserStatus userStatus) {
        this.email = email;
        this.password = password;
        this.userStatus = userStatus == null ? UserStatus.CREATED : userStatus;
    }
}
