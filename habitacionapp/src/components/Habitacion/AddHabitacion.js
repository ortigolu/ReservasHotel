import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createHabitacion } from "../../actions/habitacionActions";
import classnames from "classnames";

class AddHabitacion extends Component {
  constructor() {
    super();

    this.state = {
      habitacionName: "",
      habitacionIdentifier: "",
      description: "",
      start_date: "",
      end_date: "",
      errors: {},
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  //life cycle hooks
  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
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

    this.props.createHabitacion(newHabitacion, this.props.history);
  }

  render() {
    const { errors } = this.state;

    return (
      <div>
        {}

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
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.habitacionName,
                      })}
                      placeholder="Nombre De La Habitacion"
                      name="habitacionName"
                      value={this.state.habitacionName}
                      onChange={this.onChange}
                    />
                    {errors.habitacionName && (
                      <div className="invalid-feedback">
                        {errors.habitacionName}
                      </div>
                    )}

                    <br></br>
                  </div>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.habitacionIdentifier,
                      })}
                      placeholder="ID de Habitacion"
                      name="habitacionIdentifier"
                      value={this.state.habitacionIdentifier}
                      onChange={this.onChange}
                    />
                    {errors.habitacionIdentifier && (
                      <div className="invalid-feedback">
                        {errors.habitacionIdentifier}
                      </div>
                    )}

                    <br></br>
                  </div>
                  <div className="form-group">
                    <textarea
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.description,
                      })}
                      placeholder="Observaciones"
                      name="description"
                      value={this.state.description}
                      onChange={this.onChange}
                    />
                    {errors.description && (
                      <div className="invalid-feedback">
                        {errors.description}
                      </div>
                    )}

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
  createHabitacion: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
  errors: state.errors,
});

export default connect(mapStateToProps, { createHabitacion })(AddHabitacion);
