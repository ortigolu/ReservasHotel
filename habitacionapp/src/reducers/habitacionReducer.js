import { GET_HABITACIONES } from "../actions/types";

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
    default:
      return state;
  }
}
