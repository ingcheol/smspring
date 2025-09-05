package edu.sm.app.service;

import edu.sm.app.dto.Marker;
import edu.sm.app.repository.ShopMarkerRepository;
import edu.sm.common.frame.SmService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MarkerService implements SmService<Marker, Integer> {

    final ShopMarkerRepository shopMarkerRepository;

    @Override
    public void register(Marker marker) throws Exception {
        shopMarkerRepository.insert(marker);
    }

    @Override
    public void modify(Marker marker) throws Exception {
        shopMarkerRepository.update(marker);
    }

    @Override
    public void remove(Integer integer) throws Exception {
        shopMarkerRepository.delete(integer);
    }

    @Override
    public List<Marker> get() throws Exception {
        return shopMarkerRepository.selectAll();
    }

        public List<Marker> findByLoc(int loc) throws Exception {
        return shopMarkerRepository.findByLoc(loc);
    }


    @Override
    public Marker get(Integer integer) throws Exception {
        return shopMarkerRepository.select(integer);
    }

}