package com.ngnono.gechu.core.shiro;

import org.apache.shiro.config.Ini;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * Created by ngnono on 14-2-13.
 */

@Service
class GechuFilterChainDefinitionMapBean implements FactoryBean<Ini.Section> {

    public String getFilterChainDefinitions() {
        return filterChainDefinitions;
    }

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    private String filterChainDefinitions;


    @Override
    public Ini.Section getObject() throws Exception {
        Ini ini = new Ini();
        ini.load(getFilterChainDefinitions());   //先载入XML中定义好的chain
        //did they explicitly state a 'urls' section?  Not necessary, but just in case:
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if (CollectionUtils.isEmpty(section)) {
            //no urls section.  Since this _is_ a urls chain definition property, just assume the
            //default section contains only the definitions:
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }
    /*
     *  省略读取步骤
     *  继续加入数据库中的chain
     *  section.put("/**", "authc, roles[admin]");
     */

        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return Ini.Section.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
