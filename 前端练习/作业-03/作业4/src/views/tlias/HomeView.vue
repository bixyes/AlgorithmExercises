<template>
    <div>
      <el-container style="height: 600px; border: 1px solid #eee">
        <!-- 页面头部 -->
        <el-header style="font-size: 40px; background-color: rgb(238, 241, 246)">tlias 智能学习辅助系统</el-header>
        <el-container>
          <!-- 侧边导航栏 -->
          <el-aside width="200px">
            <el-menu :default-openeds="['1', '3']">
              <el-submenu index="1">
                <template slot="title">
                  <i class="el-icon-message"></i>
                  系统信息管理
              </template>
              <router-link to="/dept">
                <el-menu-item index="1-1">部门管理</el-menu-item>
              </router-link>
              <router-link to="/emp">
                <el-menu-item index="1-2">员工管理</el-menu-item>
              </router-link>
            </el-submenu>
          </el-menu>
        </el-aside>
          <!-- 主体展示内容 -->
          <el-main>
            <router-view></router-view>
          </el-main>
        </el-container>
      </el-container>
    </div>
  </template>
  <script>
  
  import DeptView from "./DeptView.vue";
  import EmpView from "./EmpView.vue";
  
  export default {
    comments:{DeptView,EmpView},
    data() {
      return {
        //表格展示数据
        tableData: [],
        //搜索表单输入内容
        searchForm: {
          name: "张三",
          gender: "1",
          entrydate: [],
        },
      };
    },
  };
  </script>