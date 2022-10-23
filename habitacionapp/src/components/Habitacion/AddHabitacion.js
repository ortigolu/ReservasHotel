import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createProject } from "../../actions/habitacionActions";

class AddHabitacion extends Component {
  constructor() {
    super();

    this.state = {
      habitacionName: "",
      habitacionIdentifier: "",
      description: "",
      start_date: "",
      end_date: "",
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    const newHabitacion = {
      habitacionName: this.state.habitacionName,
      habitacionIdentifier: this.state.habitacionIdentifier,
      description: this.state.description,
      start_date: this.state.start_date,
      end_date: this.state.end_date,
    };

    this.props.createProject(newHabitacion, this.props.history);
  }

  render() {
    return (
      <div>
        {
          //check name attribute input fields
          //create constructor
          //set state
          //set value on input fields
          //create onChange function
          //set onChange on each input field
          //bind on constructor
          //check state change in the react extension
        }

        <div className="project">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">Reserva de Habitacion</h5>
                <hr />
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className="form-control form-control-lg "
                      placeholder="Nombre De La Habitacion"
                      name="habitacionName"
                      value={this.state.habitacionName}
                      onChange={this.onChange}
                    />
                    <br></br>
                  </div>
                  <div className="form-group">
                    <input
                      type="text"
                      className="form-control form-control-lg"
                      placeholder="ID de Habitacion"
                      name="habitacionIdentifier"
                      value={this.state.habitacionIdentifier}
                      onChange={this.onChange}
                    />
                    <br></br>
                  </div>
                  <div className="form-group">
                    <textarea
                      className="form-control form-control-lg"
                      placeholder="Observaciones"
                      name="description"
                      value={this.state.description}
                      onChange={this.onChange}
                    />
                    <br></br>
                  </div>
                  <h6>Chech In </h6>
                  <br></br>
                  <div className="form-group">
                    <input
                      type="date"
                      className="form-control form-control-lg"
                      name="start_date"
                      value={this.state.start_date}
                      onChange={this.onChange}
                    />
                    <br></br>
                  </div>
                  <h6>Check Out</h6>
                  <br></br>
                  <div className="form-group">
                    <input
                      type="date"
                      className="form-control form-control-lg"
                      name="end_date"
                      value={this.state.end_date}
                      onChange={this.onChange}
                    />
                    <br></br>
                  </div>

                  <input
                    type="submit"
                    className="btn btn-primary btn-block mt-4"
                  />
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

AddHabitacion.propTypes = {
  createProject: PropTypes.func.isRequired,
};
export default connect(null, { createProject })(AddHabitacion);
