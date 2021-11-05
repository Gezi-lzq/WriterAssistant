<template>
    <vue-tinymce
    class="tinymce"
      v-model="content"
      :setting="setting" />
  </template>

<script>
export default {
  name: 'Editor',
  data () {
    return {
      content: '',
      setting: {
        menubar: false,
        toolbar: 'undo redo | fullscreen | formatselect alignleft aligncenter alignright alignjustify | numlist bullist | fontselect fontsizeselect forecolor backcolor | bold italic underline strikethrough | indent outdent | superscript subscript | removeformat |',
        toolbar_drawer: 'sliding',
        plugins: 'link lists fullscreen',
        language: 'zh_CN',
        height: 650
      }
    }
  }
}
</script>

<style>
#logo{
  text-align: center;
}
.tinymce{
  height: 90%;
}
</style>
