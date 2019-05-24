package com.example.templateadmin.config;

import com.example.templateadmin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysUserService sysUserService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysUserService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                // 定义当需要用户登录时候，转到的登录页面。
                // 设置登录页面
                .loginPage("/login")
                // 登录成功后的访问路径
                .defaultSuccessUrl("/")
                .failureUrl("/login-error")
                .and()
                // 定义哪些URL需要被保护、哪些不需要被保护
                .authorizeRequests()
                // 设置所有人都可以访问登录页面
                .antMatchers("/login","/login-error").permitAll()
                .antMatchers("/order-list").hasRole("ADMIN")
                // 任何请求,登录后可以访问
                .anyRequest()
                .authenticated()
                .and()
                .headers().frameOptions().disable()
                .and()
                // 关闭csrf防护
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        /*
         * 在springboot中忽略静态文件路径，直接写静态文件的文件夹 springboot默认有静态文件的放置路径，如果应用spring
         * security，配置忽略路径 不应该从springboot默认的静态文件开始
         * 如：在本项目中，所有的js和css都放在static下，如果配置忽略路径，则不能以static开始
         * 配置成web.ignoring().antMatchers("/static/*");这样是不起作用的
         */

        web.ignoring().antMatchers("/css/**", "/fonts/**","/images/**","/js/**","/layui/**");

    }

//
//    @Bean
//    public SpringResourceTemplateResolver templateResolver(){
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        //配置模板
//        templateResolver.setPrefix("classpath:/templates/");
//        templateResolver.setSuffix(".html");
//        // 之前在application.properties中看到的缓存配置
//        templateResolver.setCacheable(true);
//
//        return templateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        //模板引擎增加SpringSecurityDialect，让模板能用到sec前缀，获取spring security的内容
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        SpringSecurityDialect securityDialect = new SpringSecurityDialect();
//        Set<IDialect> dialects = new HashSet<>();
//        dialects.add(securityDialect);
//        engine.setAdditionalDialects(dialects);
//
//        engine.setTemplateResolver(templateResolver());
//        //允许在内容中使用spring EL表达式
//        engine.setEnableSpringELCompiler(true);
//
//        return engine;
//    }
//
//    //声明ViewResolver
//    @Bean
//    public ThymeleafViewResolver viewResolver(){
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        return viewResolver;
//    }
}
