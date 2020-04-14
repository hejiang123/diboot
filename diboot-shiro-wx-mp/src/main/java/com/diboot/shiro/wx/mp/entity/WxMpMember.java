package com.diboot.shiro.wx.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.diboot.core.entity.BaseEntity;
import com.diboot.shiro.entity.SysUser;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/***
 * @author Wangyl
 * @version v2.0
 * @date 2019/6/10
 */
@Data
public class WxMpMember extends BaseEntity {

    private static final long serialVersionUID = -106928701430810778L;

    @TableField("openid")
    private String openId;

    @TableField
    private Boolean subscribe;

    @TableField
    private String nickname;
    /**
     * 性别描述信息：男、女、未知等.
     */
    @TableField
    private String sexDesc;
    /**
     * 性别表示：1，2等数字.
     */
    @TableField
    private Integer sex;

    @TableField
    private String language;

    @TableField
    private String city;

    @TableField
    private String province;

    @TableField
    private String country;

    @TableField
    private String headImgUrl;

    @TableField
    private String unionId;

    @TableField
    private String remark;

    @TableField
    private Integer groupId;

    /**
     * subscribe_scene 返回用户关注的渠道来源.
     * ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他
     */
    @TableField
    private String subscribeScene;

    @Autowired
    private Long sysUserId;

    @TableField(exist = false)
    private SysUser sysUser;

}
