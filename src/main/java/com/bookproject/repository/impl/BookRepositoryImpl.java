package com.bookproject.repository.impl;

import com.bookproject.repository.BookCustomRepository;
import com.bookproject.repository.entity.BookEntity;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookCustomRepository {

    private final EntityManager entityManager;

    @Override
    public List<BookEntity> getBooks(String id, String name, String category, String isbn, String author) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> cq = cb.createQuery(BookEntity.class);
        Root<BookEntity> root = cq.from(BookEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(id)) {
            predicates.add(cb.equal(root.get("id"), id));
        }

        if (StringUtils.isNotEmpty(name)) {
            predicates.add(cb.equal(root.get("name"), name));
        }

        if (StringUtils.isNotEmpty(category)) {
            predicates.add(cb.equal(root.get("category"), category));
        }

        if (StringUtils.isNotEmpty(isbn)) {
            predicates.add(cb.equal(root.get("isbn"), isbn));
        }

        if (StringUtils.isNotEmpty(author)) {
            predicates.add(cb.equal(root.get("author"), author));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
