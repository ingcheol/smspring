package edu.sm.app.repository;

import edu.sm.app.dto.Marker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopMarkerRepository {
    void insert(Marker marker) throws Exception;
    void update(Marker marker) throws Exception;
    void delete(Integer integer) throws Exception;
    List<Marker> selectAll() throws Exception;
    Marker select(Integer integer) throws Exception;
    List<Marker> findByLoc(int loc) throws Exception;
}