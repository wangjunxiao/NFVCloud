# Prerequisites

1. you need to install an eclipse IDE or IntelliJ IDEA. 
2. insert a maven plugin into the IDE. 
3. you need to install jdk1.7+ version. 

# Credits

1. eclipse 2. IDEA 3. maven 4. doxygen

The Spring Boot MVC helps the sfctestbed in accelerating and facilitating application development. 

Application annotation: 
\DemoApplication 

	@SpringBootApplication
	@EnableJpaRepositories
	@EntityScan
	@EnableScheduling

Service annotation: 
\configplatform\ 
\openstack\ 
\service\ 
\template\ 
	
	@Service
	@Autowired

Rest annotation: 
\controller\ 

	@RestController
	@JsonIgnoreProperties
	@RequestMapping
	@CrossOrigin
	@RequestBody

DAO annotation: 
\dao\ 
	
	@Transactional
	@Query
	@Modifying

Job annotation: 
\job\ 

	@Component
	@Scheduled

Entity annotation: 
\modular\ 

	@Entity
	@Table
	@JsonIgnorePropertie
	@Id
	@GeneratedValue

The Doxygen helps the sfctestbed in class document automatic generation.
