package cn.totorotec.service.security.rbac1;

import cn.totorotec.entity.Role;
import cn.totorotec.service.security.Review;

public interface HierarchicalReview extends Review {

    /**
     * Establishes a new immediate inheritance relationship r_asc >> r_desc between existing roles r_asc, r_desc
     *
     * @param r_asc
     * @param r_desc
     */
    void addInheritance(Role r_asc, Role r_desc);

    /**
     * deletes an existing immediate inheritance relationship r_asc >> r_desc
     *
     * @param r_asc
     * @param r_desc
     */
    void deleteInheritance(Role r_asc, Role r_desc);

    void addAscendant(Role r_asc, Role r_desc);

    void addDescendant(Role r_asc, Role r_desc);

}
