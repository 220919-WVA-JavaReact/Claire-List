import {useState, useEffect} from 'react';
import axios from 'axios';
//I am the ADD SKILL component
//I take in user info
//and add the skill to our list of skills

//TODO: Abstract away list of skills
//TODO: Mock api call so we can post this info there!

function AddSkill(){ //get FORMS in here!
    const [skill, setSkill] = useState('');

    const onChange = () => {
        return null;
    }

    const onSubmit = (e) => { //review how to do this !
        e.preventDefault();
        return null;
    }

    // useEffect(()=>{ //we might deprecate useEffect for now -- can do this with simple onSubmit
    //     //ie, on click of submit, we will post via axios!
    //     axios.post('url', data)
    //         .then(res=>{
    //             //set into state
    //             setSkill(data)
    //         }).catch(err=>{
    //             console.error(err);
    //         })

    // }, [])

    return(
        <div className='add-skill-box'>

        </div>
    )
}

export default AddSkill;