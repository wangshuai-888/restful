package restful.config;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import springfox.documentation.builders.ApiInfoBuilder;
        import springfox.documentation.builders.PathSelectors;
        import springfox.documentation.builders.RequestHandlerSelectors;
        import springfox.documentation.service.ApiInfo;
        import springfox.documentation.spi.DocumentationType;
        import springfox.documentation.spring.web.plugins.Docket;
        import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    //文档属性
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder() //返回
                .title("Spring Boot中使用Swagger2构建RESTful APIs") //文档标题
                .description("优就业")                              //文档描述
                .termsOfServiceUrl("http://www.ujiuye.com/")        //支持网址
                .contact("Sunny")                                   //作者
                .version("1.0")                                     //版本号
                .build();                                           //构建
    }
    //文档具体属性
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2) .apiInfo(apiInfo()) //声明版本 调用文档属性方法
                .select() //生产文档的路径
                .apis(RequestHandlerSelectors.basePackage("restful.controller"))
                .paths(PathSelectors.any()) //选择所有的文档路径进行构建
                .build();
    }
}
