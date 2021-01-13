package Library.Project;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import Library.Project.User.User;
import Library.Project.User.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

		@Autowired
		private UserRepository repo;
		
		@Autowired
		private TestEntityManager entityManager;
		
		@Test
		public void testCreateUser()
		{
			User user = new User();
			user.setEmail("kwstaskontaras123@gmail.com");
			user.setPass("1234567");
			user.setFirstName("Konstantinos");
			user.setLastName("Kontaras");
			
			User savedUser = repo.save(user);
			
			User existingUser =  entityManager.find(User.class, savedUser.getId());
			
			assertThat(existingUser.getEmail()).isEqualTo(user.getEmail());
		}
		
		@Test
		public void testFindUserByEmail()
		{
			String email = "KATI_ASXETO_GIA_NA_APOTUXEI_TO_TEST@gmail.com";
			
			User user = repo.findByEmail(email);
			assertThat(user).isNotNull();
		}
}
