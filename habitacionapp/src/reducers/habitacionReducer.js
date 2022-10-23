import {
  GET_HABITACION,
  GET_HABITACIONES,
  DELETE_HABITACION,
} from "../actions/types";

const initialState = {
  habitaciones: [],
  habitacion: {},
};

export default function (state = initialState, action) {
  switch (action.type) {
    case GET_HABITACIONES:
      return {
        ...state,
        habitaciones: action.payload,
      };

    case GET_HABITACION:
      return {
        ...state,
        habitacion: action.payload,
      };

    case DELETE_HABITACION:
      return {
        ...state,
        habitaciones: state.habitaciones.filter(
          (habitacion) => habitacion.identificadorHabitacion !== action.payload
        ),
      };
    default:
      return state;
  }
}
