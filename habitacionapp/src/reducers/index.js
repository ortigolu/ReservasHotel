import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import habitacionReducer from "./habitacionReducer";

export default combineReducers({
  errors: errorReducer,
  habitacion: habitacionReducer,
});
