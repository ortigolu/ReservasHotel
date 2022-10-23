import axios from "axios";
import { GET_ERRORS, GET_HABITACIONES } from "./types";

export const createHabitacion = (habitacion, history) => async (dispatch) => {
  try {
    const res = await axios.post(
      "http://localhost:8080/api/habitacion",
      habitacion
    );
    history.push("/dashboard");
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data,
    });
  }
};

export const getHabitaciones = () => async (dispatch) => {
  const res = await axios.get("http://localhost:8080/api/habitacion/all");
  dispatch({
    type: GET_HABITACIONES,
    payload: res.data,
  });
};
