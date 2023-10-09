import { ref } from "vue";
import { defineStore } from "pinia";

export const useUserStore = defineStore("user", () => {
  const username = ref(window.localStorage.uname || "");
  const role = ref(window.localStorage.role || "");

  const setUsername = (account: string) => {
    username.value = account;
  };

  const setRole = (roleName: string) => {
    role.value = roleName;
  };

  return { username, role, setUsername, setRole };
});
