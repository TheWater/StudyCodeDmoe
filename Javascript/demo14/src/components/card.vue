<template>
  <div id="card">
    <div class="radio-group"
         v-model="tabView">
      <span v-for="(tag,index) in tags"
            :class="{cur:iscur==index}"
            @click="iscur=index,tabChange('select'+(index+1))">{{tag.name}}</span>
    </div>
    <transition name="fade"
                >
      <keep-alive>
        <component v-bind:is="tabView"></component>
      </keep-alive>
    </transition>

  </div>
</template>

<script>
import select1 from '../components/select1.vue'
import select2 from '../components/select2.vue'
import select3 from '../components/select3.vue'
export default {
  name: 'card',
  data() {
    return {
      tabView: 'select1',
      iscur: 0,
      tags: [{ name: '小猪佩奇' }, { name: '汪汪队' }, { name: '变形金刚' }],
    }
  },
  components: {
    select1,
    select2,
    select3,
  },
  methods: {
    tabChange: function (tab) {
      this.tabView = tab
    },
  },
}
</script>

<style>
.radio-group {
  padding: 20px;
}
.span {
  width: 60px;
  text-align: center;
}
.cur {
  color: brown;
}
.fade-enter-active,
.fade-leave-active {
  transition: opacity 1s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
</style>