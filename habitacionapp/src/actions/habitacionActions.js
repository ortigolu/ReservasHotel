import axios from "axios";
import {
  GET_ERRORS,
  GET_HABITACION,
  GET_HABITACIONES,
  DELETE_HABITACION,
} from "./types";

export const createHabitacion = (habitacion, history) => async (dispatch) => {
  try {
    const res = await axios.post("/api/habitacion", habitacion);

    history.push("/dashboard");
    dispatch({
      type: GET_ERRORS,
      payload: {},
    });
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data,
    });
  }
};

export const getHabitaciones = () => async (dispatch) => {
  const res = await axios.get("/api/habitacion/all");

  dispatch({
    type: GET_HABITACIONES,
    payload: res.data,
  });
};

export const getHabitacion = (id, history) => async (dispatch) => {
  try {
    const res = await axios.get(`/api/habitacion/${id}`);
    dispatch({
      type: GET_HABITACION,
      payload: res.data,
    });
  } catch (error) {
    history.push("/dashboard");
  }
};

export const deleteHabitacion = (id) => async (dispatch) => {
  if (window.confirm("Esta seguro?")) {
    await axios.delete(`/api/habitacion/${id}`);
    dispatch({
      type: DELETE_HABITACION,
      payload: id,
    });
  }
};
