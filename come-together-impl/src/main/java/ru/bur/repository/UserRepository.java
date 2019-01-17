package ru.bur.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.bur.domain.AppUser;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByPhoneNumber(String phoneNumber);

    AppUser findByAuthorizationToken(String phoneNumber);

}

/*
@RepositoryRestResource
public interface ItemRepo extends PagingAndSortingRepository<Item, Long> {  //это extends CrudRepository

    @RestResource(path = "byMaxPrice")
    @Query("SELECT i FROM Item i WHERE i.price <= :maxPrice")
    List<Item> findItemsLessThan(@Param("maxPrice") double maxPrice);

    @RestResource(path = "byMaxPriceAndType")
    @Query("SELECT i FROM Item i WHERE i.price <= :maxPrice AND i.type = :type")
    List<Item> findItemsLessThanAndType(@Param("maxPrice") double maxPrice, @Param("type") String type);
}

*/