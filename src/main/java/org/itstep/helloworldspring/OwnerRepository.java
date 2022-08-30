package org.itstep.helloworldspring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

