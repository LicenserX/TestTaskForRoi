package com.licenser.testtaskforroi.repository;

import com.licenser.testtaskforroi.entity.CategoryPO;
import com.licenser.testtaskforroi.entity.CategoryPO_;
import com.licenser.testtaskforroi.entity.ProductPO;
import com.licenser.testtaskforroi.entity.ProductPO_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;
import java.util.List;

public class ProductImpl implements Product {


    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ProductPO> getByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<ProductPO> poCriteriaQuery = cb.createQuery(ProductPO.class);
        Root<ProductPO> productPORoot = poCriteriaQuery.from(ProductPO.class);
        poCriteriaQuery.select(productPORoot);
        poCriteriaQuery.where(cb.like(productPORoot.get(com.licenser.testtaskforroi.entity.ProductPO_.name),
                "%" + name + "%"));
        return em.createQuery(poCriteriaQuery).getResultList();
    }

    @Override
    public List<ProductPO> getByCategory(String type) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductPO> poCriteriaQuery = cb.createQuery(ProductPO.class);
        Root<ProductPO> productPORoot = poCriteriaQuery.from(ProductPO.class);
        poCriteriaQuery.select(productPORoot);
        SetJoin<ProductPO, CategoryPO> join = productPORoot.join(ProductPO_.category);
        poCriteriaQuery.where(cb.equal(join.get(CategoryPO_.type), type));
        return em.createQuery(poCriteriaQuery).getResultList();
    }
}
