import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class TestOrika {
    public static void main(String[] args) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(User.class, UserA.class)
                .field("id", "id")
                .field("name", "name")
                .byDefault()
                .register();

        User user = new User(123L, "小明");

        MapperFacade mapper = mapperFactory.getMapperFacade();

        UserA userA = mapper.map(user, UserA.class);
        System.out.println(userA.toString());
    }
}
