package boot.repository;

import boot.entity.Asset;
import org.springframework.data.repository.CrudRepository;

import boot.entity.User;

public interface AssetRepository{

    public void insert(Asset asset);

}