<template>
  <div class="hello">
    <el-form  :label-position="labelPosition" label-width="100px" :model="form">
        <el-form-item label="用户名">
          <el-input v-model="form.name" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="form.age" placeholder="请输入年龄"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">添加</el-button>
          <el-button type="danger" @click="resetForm('form')">重置</el-button>
        </el-form-item>
    </el-form>

    <el-table :data="tableDate"
      style="100%">
      <el-table-column prop="num" label="序号" ></el-table-column>
      <el-table-column prop="name" label="姓名" ></el-table-column>
      <el-table-column prop="age" label="年龄" ></el-table-column>
      <el-table-column prop="but" label="操作" >
        <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">删除</el-button>
        
      </template>
      </el-table-column>
    </el-table>
    <el-button type="danger" @click="del">删除全部</el-button>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      labelPosition:'top',
      input:'',
      form:{
        num:'',
        name:'',
        age:''
      },
      tableDate:[
        {
          num:1,
          name:'里斯',
          age:18

        }
      ]
    }
  },
  methods:{
    submitForm() {
        this.$alert('确认添加？', {
          showCancelButton: true,
          confirmButtonText: '确定',
          cancelButtonText:'取消',
          type: 'warning'}).then(()=>{
            var obj={num:this.tableDate.length+1,name:this.form.name,age:this.form.age}
            this.tableDate.push(obj);
            this.$message({
              type:'success',
              message:'添加成功！'
            });
          }).catch(()=>{
            this.$message({
              type:'info',
              message:'已取消添加'
            })
          })
      
    },
      resetForm(formName) {
        this.$alert('确认要删除')
        this.form={num:'',
        name:'',
        age:''}
      },
      del(){
        this.$alert('确认要删除全部记录?',{
          showCancelButton: true,
          confirmButtonText: '确定',
          cancelButtonText:'取消',
          type:'danger'
        }).then(()=>{
          this.tableDate=[],
          this.$message({
            type:'success',
            message:'删除全部用户成功！'
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
        
      },
      handleClick(hah){
        this.$alert('确认删除',{
          showCancelButton: true,
          confirmButtonText: '确定',
          cancelButtonText:'取消',
        }).then(()=>{
            let id1 = this.tableDate.findIndex(item => {
              if (item.num == hah.num) {
                return true
              }
            })
            this.tableDate.splice(id1, 1)
            this.$message({
              type:'success',
              message:'删除单用户成功！'
            })
        })
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
p{
  text-align: left;
}
</style>
