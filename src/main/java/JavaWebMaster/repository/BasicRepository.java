package JavaWebMaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JavaWebMaster.entity.Basic;
import JavaWebMaster.entity.User;

@Repository
public interface BasicRepository extends JpaRepository<Basic, Integer>
{
	public List<Basic> findByOwner(User currentUser);
	
	//public void update(Basic theBasic);
}
