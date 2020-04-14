package com.diboot.shiro.wx.mp.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.diboot.core.util.V;
import com.diboot.shiro.config.AuthType;
import com.diboot.shiro.entity.SysUser;
import com.diboot.shiro.jwt.BaseJwtAuthenticationToken;
import com.diboot.shiro.service.AuthWayService;
import com.diboot.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * 微信公众号认证实现
 * @author Wangyl
 * @version v2.0
 * @date 2019/6/10
 */
@Service
public class WxMpAuthWayServiceImpl implements AuthWayService {

    @Autowired
    private SysUserService sysUserService;

    private AuthType authType = AuthType.WX_MP;

    private BaseJwtAuthenticationToken token;

    @Override
    public AuthType authType() {
        return authType;
    }

    @Override
    public void initByToken(BaseJwtAuthenticationToken token) {
        this.token = token;
    }

    @Override
    public SysUser getUser() {
        //查看绑定的账户
        List<SysUser> sysUserList = sysUserService.getEntityList(
                Wrappers.<SysUser>lambdaQuery()
                        .eq(SysUser::getOpenid, token.getAccount())
                        .eq(SysUser::getUserType, token.getIUserType().getType())
        );
        if (V.isEmpty(sysUserList)) {
            return null;
        }
        return sysUserList.get(0);
    }

    @Override
    public boolean requirePassword() {
        return authType.isRequirePassword();
    }

    @Override
    public boolean isPasswordMatch() {
        return true;
    }

    @Override
    public boolean isPreliminaryVerified() {
        return false;
    }

    @Override
    public Long getExpiresInMinutes() {
        return null;
    }
}
