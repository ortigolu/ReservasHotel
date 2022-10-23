import React from "react";
import { Link } from "react-router-dom";

const CreateHabitacionButton = () => {
  return (
    <React.Fragment>
      <Link to="/addHabitacion" className="btn btn-lg btn-info">
        Nueva Habitación
      </Link>
    </React.Fragment>
  );
};
export default CreateHabitacionButton;
