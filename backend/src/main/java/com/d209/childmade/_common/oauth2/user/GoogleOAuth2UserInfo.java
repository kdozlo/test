package com.d209.childmade._common.oauth2.user;

import lombok.Builder;

import java.util.Map;

public class GoogleOAuth2UserInfo implements OAuth2UserInfo {

    private final Map<String, Object> attributes;
    private final String accessToken;
    private final String id;
    private final String email;
    private final String name;
    private final String nickName;
    private final String profileImageUrl;

    @Builder
    private GoogleOAuth2UserInfo(String accessToken, Map<String, Object> attributes) {
        this.accessToken = accessToken;
        this.attributes = attributes;
        this.id = (String) attributes.get("sub");
        this.email = (String) attributes.get("email");
        this.name = (String) attributes.get("name");
        this.nickName = null;
        this.profileImageUrl = (String) attributes.get("picture");
    }

    public static GoogleOAuth2UserInfo of(String accessToken, Map<String, Object> attributes) {
        return builder()
                .accessToken(accessToken)
                .attributes(attributes)
                .build();
    }

    @Override
    public OAuth2Provider getProvider() {
        return OAuth2Provider.GOOGLE;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNickname() {
        return nickName;
    }

    @Override
    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
