<template>
  <div
    ref="node"
    :style="nodeContainerStyle"
    @click="clickNode"
    @mouseup="changeNodeSite"
    :class="nodeContainerClass"
  >
    <!-- 最左侧的那条竖线 -->
    <div class="ef-node-left"></div>
    <!-- 节点类型的图标 -->
    <div class="ef-node-left-ico flow-node-drag">
      <i :class="nodeIcoClass"></i>
    </div>
    <!-- 节点内容 -->
    <div class="ef-node-text" :show-overflow-tooltip="true">
        {{ node.name }}
    </div>
    <!-- 节点状态图标 -->
    <div class="ef-node-right-ico">
      <i
        class="el-icon-circle-check el-node-state-success"
        v-show="node.state === 'success'"
      ></i>
      <i
        class="el-icon-circle-close el-node-state-error"
        v-show="node.state === 'error'"
      ></i>
      <i
        class="el-icon-warning-outline el-node-state-warning"
        v-show="node.state === 'warning'"
      ></i>
      <i
        class="el-icon-loading el-node-state-running"
        v-show="node.state === 'running'"
      ></i>
    </div>
  </div>
</template>

<script>
export default {
// 由父节点传来
  props: {
    node: Object,
    activeElement: Object
  },
  data() {
    return {}
  },
  computed: {
    // nodeContainerClass计算属性，依赖于this.activeElement.type
    //                                 this.activeElement.nodeId 这两个值
    nodeContainerClass() {
      return {
        // 为一个node结点
        'ef-node-container': true,
        'ef-node-active':
        // 当前是否存在node被激活               // 如果存在是否为当前结点id
          this.activeElement.type === 'node' ? this.activeElement.nodeId === this.node.id
            : false
      }
    },
    // 节点容器样式 (当node内存入的top,left发生变化,该div的样式也随之改变)
    nodeContainerStyle() {
      return {
        top: this.node.top,
        left: this.node.left
      }
    },
    // 依赖于 this.node.ico this.node.viewOnly 更改Node的图标与可编辑属性的样式
    nodeIcoClass() {
      var nodeIcoClass = {}
      nodeIcoClass[this.node.ico] = true
      // 添加该class可以推拽连线出来，viewOnly 可以控制节点是否运行编辑
      nodeIcoClass['flow-node-drag'] = !this.node.viewOnly
      console.log(nodeIcoClass)
      return nodeIcoClass
    }
  },
  methods: {
    // 点击节点
    clickNode() {
      this.$emit('clickNode', this.node.id)
    },
    // 鼠标移动后抬起
    changeNodeSite() {
      // 避免抖动(如果仅是点击一下未发生移动)
      if (
        this.node.left === this.$refs.node.style.left &&
        this.node.top === this.$refs.node.style.top
      ) {
        return
      }
      // 改变结点位置,重新渲染
      this.$emit('changeNodeSite', {
        nodeId: this.node.id,
        left: this.$refs.node.style.left,
        top: this.$refs.node.style.top
      })
    }
  }
}
</script>
