import React, {useEffect, useState} from 'react';

const FieldMappings: React.FC<IProps> = ({
	carouselFieldsData,
	...otherProps
}) => {
    return (
        <>
            <h1>carouselFieldsData</h1>
        </>
    );
};

export default StreamingView;

interface IProps {
	carouselFieldsData?: string;
}