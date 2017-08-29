package weixin.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by Administrator on 2016/7/15.
 * IntelliJ IDEA 2016 of gzcss
 */
public class InitTokenParm implements ApplicationListener<ContextRefreshedEvent>{

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            System.out.println("InitTokenParm. init spring mvc wzy");
        }
    }
}
