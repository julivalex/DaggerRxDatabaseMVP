package com.java.note.dagger_rx_database_mvp.mapper;

import com.java.note.dagger_rx_database_mvp.mvp.model.Cake;
import com.java.note.dagger_rx_database_mvp.mvp.model.CakesResponse;
import com.java.note.dagger_rx_database_mvp.mvp.model.CakesResponseCakes;
import com.java.note.dagger_rx_database_mvp.mvp.model.Storage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CakeMapper {

    @Inject
    public CakeMapper() {
    }

    public List<Cake> mapCakes(Storage storage, CakesResponse response) {
        List<Cake> cakeList = new ArrayList<>();

        if (response != null) {
            CakesResponseCakes[] responseCakes = response.getCakes();
            if (responseCakes != null) {
                for (CakesResponseCakes cake : responseCakes) {
                    Cake myCake = new Cake();
                    myCake.setId(cake.getId());
                    myCake.setTitle(cake.getTitle());
                    myCake.setDetailDescription(cake.getDetailDescription());
                    myCake.setPreviewDescription(cake.getPreviewDescription());
                    myCake.setImageUrl(cake.getImage());
                    storage.addCake(myCake);
                    cakeList.add(myCake);
                }
            }
        }
        return cakeList;
    }
}
