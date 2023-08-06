<template>
    <div>
          <!-- 主体展示内容 -->
          <el-main>
            <!-- 表单 -->
            <el-form :inline="true" :model="searchForm" class="demo-form-inline">
              <el-form-item label="姓名">
                <el-input v-model="searchForm.name" placeholder="姓名"></el-input>
              </el-form-item>
              <el-form-item label="性别">
                <el-select v-model="searchForm.gender" placeholder="性别">
                  <el-option label="男" value="1"></el-option>
                  <el-option label="女" value="2"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="入职日期">
                <el-date-picker
                  v-model="searchForm.entrydate"
                  type="daterange"
                  range-separator="至"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期"
                ></el-date-picker>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit">查询</el-button>
              </el-form-item>
            </el-form>
  
            <el-table :data="tableData">
              <el-table-column prop="name" label="姓名" width="180"></el-table-column>
              <el-table-column prop="image" label="图像" width="180">
                <template slot-scope="scope">
                  <img :src="scope.row.image" width="100px" height="70px" />
                </template>
              </el-table-column>
              <el-table-column prop="gender" label="性别" width="140">
                <template slot-scope="scope">{{scope.row.gender==1?"男":"女"}}</template>
              </el-table-column>
              <el-table-column prop="job" label="职位" width="140"></el-table-column>
              <el-table-column prop="entrydate" label="入职日期" width="180"></el-table-column>
              <el-table-column prop="updatetime" label="最后操作时间" width="230"></el-table-column>
              <el-table-column label="操作">
                <el-button type="primary" size="mini">编辑</el-button>
                <el-button type="danger" size="mini">删除</el-button>
              </el-table-column>
            </el-table>
            <!-- Pagination分页 -->
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              background
              layout="sizes,prev, pager, next,jumper,total"
              :total="1000"
            ></el-pagination>
          </el-main>
        
    </div>
  </template>
  <script>
  //导入axios
  import axios from "axios";
  
  export default {
    mounted() {
      axios
        .get("https://yapi.pro/mock/43658/emp/list")
        .then((resp) => {
          this.tableData = resp.data.data; //响应数据赋值给数据模型
        });
    },
    methods: {
      onSubmit: function () {
        console.log(this.searchForm);
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      },
    },
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