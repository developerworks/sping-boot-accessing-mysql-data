/**
 * 资源
 */
package cn.totorotec.entity;

import org.springframework.web.bind.annotation.RequestMethod;

public class Resource extends AbstractEntity {

    /**
     * 资源名称
     */
    private String name;
    private String title;

    /**
     * 资源地址
     */
    private String url;

    /**
     * 资源描述
     */
    private String description;

    /**
     * 是否禁用
     */
    private boolean disabled;
}
