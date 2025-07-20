package com.bnw.taskcinema.service.common;

import com.bnw.taskcinema.model.AbstractEntity;

import java.util.List;

import static com.bnw.taskcinema.utils.ExceptionMsgConst.UN_SUPPORT_METHOD;

public interface IService<T extends AbstractEntity> {

    default List<T> findAll() {
        throw new UnsupportedOperationException(UN_SUPPORT_METHOD);
    }

    default T findById(Integer id) {
        throw new UnsupportedOperationException(UN_SUPPORT_METHOD);
    }

    default T save(T entity) {
        throw new UnsupportedOperationException(UN_SUPPORT_METHOD);
    }

    default T update(T entity) {
        throw new UnsupportedOperationException(UN_SUPPORT_METHOD);
    }

    default void delete(Integer id) {
        throw new UnsupportedOperationException(UN_SUPPORT_METHOD);
    }
}
