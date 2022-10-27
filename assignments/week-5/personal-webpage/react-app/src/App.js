import About from './components/About';
import ProfilePic from './components/ProfilePic';
import Nav from './components/Nav';
import Message from './components/Message';
import ListSkills from './components/ListSkills';

function App() {
  return (
    <div className="body">
      <About />
      <Nav />
      <ProfilePic />
      <Message />
      <ListSkills />
    </div>
  );
}

export default App;
