import { createApp } from "vue";
import "./style.css";
import App from "./App.vue";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import router from "./router/index.ts";
import { createPinia } from "pinia";
import preventMultiClick from "./utils/preventMultiClick";

const app = createApp(App);
const pinia = createPinia();

app.use(preventMultiClick);
app.use(router);
app.use(pinia);
app.use(ElementPlus);

app.mount("#app");
