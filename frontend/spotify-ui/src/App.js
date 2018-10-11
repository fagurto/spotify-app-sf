import 'bootstrap/dist/css/bootstrap.css';
import {  Input , Button ,  Form, FormGroup , Navbar, NavbarBrand ,Col, Row , Table,Alert } from 'reactstrap';
import React, { Component } from 'react';


const SearchResults=({albums})=>{
   return (
    <Table>
      <thead>
        <tr>
          <th>Nombre </th>
          <th>Fecha de lanzamiento </th>
          <th>Tipo</th>
          <th>Numero de temas</th>
          <th>Imagen</th>
        </tr>
      </thead>
      <tbody>
        {albums.map((album,i)=>{
           return (
             <tr key={i}>
               <td>{album.name}</td>
               <td>{album.release_date}</td>
               <td>{album.type}</td>
               <td>{album.total_tracks}</td>
               <td><img src={album.images[2].url}></img></td>
             </tr>
           );
        })}
      </tbody>
  </Table>
   );
}

class SearchBar extends Component {
  constructor(){
     super();
     this.state={
       artista:"",
       album:"",
       isValid:true
     };
  }

  handleSubmit(){
    const {artista,album}=this.state;
    if(!artista && !album){
        this.setState({isValid:false});
    }
    else{
      this.props.onSubmit({artista,album});
      this.setState({isValid:true,artista:"",album:""});
    }
    
  }
  handleInputChange(e){
    this.setState({
      [e.target.name]: e.target.value
    });
  } 
  render(){
    return (
      <div>
      {
        !this.state.isValid?
         <Alert color="danger">Debes ingresar un Artista o un Album</Alert> :''
      }
      <Form inline>
        <FormGroup >
          <Input  value={ this.state.artista } onChange={ this.handleInputChange.bind(this) } type="text" name="artista" id="artista" placeholder="Nombre del artista" />
        </FormGroup>
          {' '}
        <FormGroup >  
          <Input value={ this.state.album } onChange={ this.handleInputChange.bind(this) } type="text" name="album" id="album" placeholder="Nombre del album" />
        </FormGroup>
          {' '}
        <FormGroup >
          <Button onClick={this.handleSubmit.bind(this)} type="button">Buscar</Button>
        </FormGroup>
      </Form>
      </div>
    );
  }
}

const AppShell = ({onSubmit,albums})=>{
   return (
     <div>
      <Navbar color="light" light >
        <NavbarBrand >Spotify App</NavbarBrand>
      </Navbar>
      <Col>
        <Row>
          <Col>
            <SearchBar onSubmit={onSubmit} />
          </Col>
        </Row>
        <SearchResults albums={albums}/>
      </Col>
     </div>
   );
}





class App extends Component {

  constructor(){
    super();
    this.state={
      albums:[]
    }
  }
  onSubmit(form){
     const { artista , album }= form;

     fetch(`http://localhost:8090/api/albums?artist=${artista}&album=${album}`).then(response=>{

         return response.json().then(data=>{
              const { albums } = data;
              this.setState({albums});
         });
     });
  }
  render() {
    return (
      <AppShell onSubmit={this.onSubmit.bind(this)}  albums={this.state.albums}/>
    );
  }
}

export default App;
