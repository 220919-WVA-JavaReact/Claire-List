//The RIGHT way of doing things
//is sometimes very annoying

import Skill from './Skill'; //To write!!

function ListSkills(){ //TODO make AddSkill component
    const skills = [ //maybe add experience level?
    //this would normall come from an external resource, like an API call.
        {
            id: 1,
            text: 'Java'
        },
        {
            id: 2,
            text: 'JavaScript'
        },
        {
            id: 3,
            text: 'React'
        },
        {
            id: 4,
            text: 'Node.js'
        },
        {
            id: 5,
            text: 'Express'
        },
        {
            id: 6,
            text: 'PostgreSQL'
        },
        {
            id: 7,
            text: 'MongoDB'
        },
    ]

    //REMEMBER: use the 'key' "attribute" for mapping objects, CLAIRE

    return (
        <div className='list-skills'>
        <h2>Here is a(n incomplete) list of MY skills!</h2>
        <ul className='list-actual'>
            {
                skills.map( skill => {
                    return <Skill key={skill.id} text={skill.text} />
                } )
            }
        </ul>
        </div>
    )
}

export default ListSkills;