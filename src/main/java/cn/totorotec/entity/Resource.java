/**
 * 资源
 */
package cn.totorotec.entity;

import org.springframework.web.bind.annotation.RequestMethod;

public class Resource extends AbstractEntity {
    private String title;
    private String url;
    private String description;

    private boolean disabled;

    private RequestMethod method;
}
