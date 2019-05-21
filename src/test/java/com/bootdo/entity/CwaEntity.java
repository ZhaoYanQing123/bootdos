package com.bootdo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 考勤实体
 */
public class CwaEntity {

        String sname;

        List <AttenEntity> attenList=new ArrayList();

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public List<AttenEntity> getAttenList() {
            return attenList;
        }

        public void setAttenList(List<AttenEntity> attenList) {
            this.attenList = attenList;
        }
}
