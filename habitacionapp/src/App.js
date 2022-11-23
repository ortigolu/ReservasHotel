import "./App.css";
import Dashboard from "./components/Dashboard";
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import AddHabitacion from "./components/Habitacion/AddHabitacion";
import { Provider } from "react-redux";
import store from "./store";
import updateHabitacion from "./components/Habitacion/UpdateHabitacion";
import Landing from "./components/Layout/Landing";
import Register from "./components/UserManagement/Register";
import Login from "./components/UserManagement/Login";
function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="App">
          <Header />
          <Routes>
            <Route exact path="/" element={<Landing />} />
            <Route exact path="/register" element={<Register />} />
            <Route exact path="/login" element={<Login />} />
            <Route exact path="/dashboard" element={<Dashboard />} />
            <Route exact path="/addHabitacion" element={<AddHabitacion />} />
            <Route
              exact
              path="/updateHabitacion/:id"
              element={<updateHabitacion />}
            />
          </Routes>
        </div>
      </Router>
    </Provider>
  );
}

export default App;
