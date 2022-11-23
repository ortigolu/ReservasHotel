import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import habitacionReducer from "./habitacionReducer";
import securityReducer from "./securityReducer";

export default combineReducers({
  errors: errorReducer,
  habitacion: habitacionReducer,
  security: securityReducer,
});
