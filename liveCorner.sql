CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE public.animal(
                            id uuid DEFAULT public.uuid_generate_v4() PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
							animal_class_id UUID NOT NULL,
							animal_type_id UUID NOT NULL,
							storage_location_id UUID NOT NULL
					
);

CREATE TABLE public.animal_class(
                            id uuid DEFAULT public.uuid_generate_v4() PRIMARY KEY,
                            name VARCHAR(255) NOT NULL
);

CREATE TABLE public.animal_type(
                            id uuid DEFAULT public.uuid_generate_v4() PRIMARY KEY ,
                            name VARCHAR(255) NOT NULL
);

CREATE TABLE public.storage_location(
                            id uuid DEFAULT public.uuid_generate_v4(),
                            name VARCHAR(255) NOT NULL,
							animal_type_id UUID NOT NULL
);


ALTER TABLE public.animal
    ADD CONSTRAINT fk_animal_animal_class
        FOREIGN KEY(animal_class_id) REFERENCES public.animal_class(id) ON DELETE CASCADE;

ALTER TABLE public.animal
    ADD CONSTRAINT fk_animal_animal_type
        FOREIGN KEY(animal_type_id) REFERENCES public.animal_type(id) ON DELETE CASCADE;

ALTER TABLE public.animal
    ADD CONSTRAINT fk_animal_storage_location
        FOREIGN KEY(storage_location_id) REFERENCES public.storage_location(id) ON DELETE CASCADE;
		
ALTER TABLE public.storage_location
    ADD CONSTRAINT fk_storage_location_animal_type_id
        FOREIGN KEY(animal_type_id) REFERENCES public.animal_type(id) ON DELETE CASCADE;

