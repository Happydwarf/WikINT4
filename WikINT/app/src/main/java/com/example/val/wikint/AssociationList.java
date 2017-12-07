package com.example.val.wikint;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by alexisblervaque on 24/11/2017.
 */

public class AssociationList extends Activity {

    private GridLayout AssoContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.association_list);


        AssoContainer = findViewById(R.id.AssoContainer);


        //Get Back the list of association;
        ArrayList<Association> AssociationList = new ArrayList<Association>();
        String description_bde = "Avec : une semaine et un week-end d’intégration à ne rater sous aucun prétexte, des soirées de folies et des voyages dans les capitales Européennes, tu n’auras pas le temps de t’ennuyer !\n" +
                "\n" +
                "Tu pourras aussi renforcer tes liens auprès de grandes entreprises lors de journées professionnelles organisées par nos soins.\n" +
                "\n" +
                "Tu ne pourras pas nous louper avec nos polos bleus sur les épaules, n’hésite surtout pas à venir nous voir si tu as la moindre question lors de ton arrivée, nous serons là pour t’accueillir !\n" +
                "\n" +
                "Comment faire partie du BDE ?\n" +
                "\n" +
                "La tâche est difficile mais la satisfaction n’en est que plus grande.\n" +
                "\n" +
                "Tu as certainement entendu parler des célèbres campagnes BDE dans les plus grandes Écoles, rien à voir avec la nôtre ! C’est L’ÉVÉNEMENT incontournable de l’année, tout le campus est rythmé autour de ces mois de campagne où tu devras montrer au campus que tu es à la hauteur de tes ambitions ! Rien de mieux pour trouver une nouvelle famille et réaliser les événements les plus fous, impensables à ton arrivée.\n" +
                "\n" +
                "Alors rejoins les plus motivés de ta promo et sois prêt pour marquer à ton tour l’histoire de nos deux écoles à tout jamais !";
        String description_asint = "...Qu’est ce que c’est ?\n" +
                "\n" +
                "L’ASINT comme son nom l’indique, est l’association qui gère toutes les activités sportives des étudiants de nos deux écoles, mais cela n’en fait pas le classique BDS que l’on y trouve dans les autres écoles.\n" +
                "\n" +
                "C’est bien plus que cela, il s’agit en effet de la deuxième association du campus, avec une identité et des valeurs fortes, qui tiennent une place de choix dans la vie de l’INT. Il sera d’ailleurs difficile de passer à côté des polos roses pendant la SEI et le WEI, alors puisque l’ASINT vaut mieux qu’un long discours, on t’invite à venir découvrir notre univers toute la semaine.\n" +
                "\n" +
                "...Qu’est ce qu’on y fait ?\n" +
                "\n" +
                "Cotisez et vous pourrez profiter de toutes les infrastructures sportives de notre beau campus: terrains de tennis, terrain de basket, gymnase, salle de musculation, street workout… Vous pourrez aussi pratiquer en loisirs ou en compétition (championnats universitaires) des sports encadrés par des professionnels tels que: Rugby, Foot, Hand, Basket, Volley, Badminton,Tennis, Sports de combat, Musculation (tous les jours de la semaine), …Des partenariats avec des clubs d’équitation, d’escalade et de golf existent et permettent de pratiquer ces sports à prix réduit.\n" +
                "\n" +
                "Mais l’ASINT c’est aussi 3 soirées, dont celle de la SEI en collaboration avec le BDA, des événements sportifs, et bien sûr le Week End Ski !\n" +
                "\n" +
                "PORTRAIT CHINOIS\n" +
                "\n" +
                "Si l’ASINT était …\n" +
                "\n" +
                "Un animal… Un gros cochon qui montre son postérieur\n" +
                "\n" +
                "Un sport… de chambre\n" +
                "\n" +
                "CETTE ASSO VOUS PLAÎT ? Intégrez-là !\n" +
                "\n" +
                "Sauf qu’on intègre pas l’ASINT, c’est l’ASINT qui t’intègre.\n" +
                "\n" +
                "Pour devenir un vrai ASINT tu dois lister lors de la terrible campagne ASINT, c’est à dire participer avec une liste de potes à une campagne d’environ 2 mois où tu organiseras des événements sportifs et des soirées, animeras le Week-End Ski, ... et peut-être que Youyou te laissera reprendre le flambeau après des efforts acharnés !" ;


        String description_BDA = "Le BDA est l'association qui gère les arts et divertissements sur le campus.\n" +
                "\n" +
                "Ton truc c'est plutôt la danse ou le chant? La musique ou le cinéma? Le théâtre ou la cuisine? La photo ou le dessin?\n" +
                "\n" +
                "Quels que soient tes loisirs, au BDA il y a le club dans lequel tu pourras vivre ta passion. Nous vivons les nôtres au sein de nos 18 clubs et en faisons profiter le campus en proposant des scènes ouvertes pour mettre les talents de l'école en scène, des concerts. Mais aussi des sorties culturelles sur Paris et bien sur des soirées au cours de l'année.\n" +
                "\n" +
                "Que tu sois novice, confirmé ou simple amateur, tout le monde à sa place au BDA! Nous sommes tous très différents les uns des autres ce qui fait de nous une grande communauté mais surtout un groupe très soudé.";

        String description_absinthe = "AbsINThe c'est le bar de l'école !\n" +
                "\n" +
                "AbsINThe possède une triple mission au sein du campus. Il s’agit du bar de TMSP et possède une licence III qui lui permet de vendre de la bière. À côté de cela, il dispose de soft et de snacks ainsi que des pizzas pour permettre aux étudiants de prendre des forces en soirée. Ainsi, il incarne un espace de détente après les cours et surtout un endroit de partage. Ses horaires d’ouverture se situent entre 22h et 1h du matin.\n" +
                "\n" +
                "De plus, AbsINThe possède un local bien particulier puisque le bar a la responsabilité de la grande salle. Le club travaille en ce sens en étroite collaboration avec la Maisel. Il est donc au centre de la vie associative et permet à chaque association de disposer d'un lieu libre pour s'affirmer et de créer régulièrement des animations.\n" +
                "\n" +
                "Enfin, AbsINThe se porte garante de la cohésion associative. Lors d’animations organisées le Mercredi, il permet de créer du lien entre les associations qui peuvent se promouvoir dans la grande salle du foyer.\n" +
                "\n" +
                "NB : Si tu veux devenir barman ou barmaid, pas de soucis, on se charge de ta formation au terme d’une cérémonie traditionnelle et culte au sein de cette école.";


        AssociationList.add(new Association("ASINT 2017 - Fireballs", 1, "asint_logo", "Alexis Perrin", "RDC Foyer", description_asint, "cover_asint", null, null));
        AssociationList.add(new Association("BDE 2017 - Apocalypse", 2, "logo_bde", "Théo Pradère", "RDC Foyer",description_bde , "cover_bde", null, null));
        AssociationList.add(new Association("BDA", 3, "logo_bda", "Clément Jubault", "RDC Foyer", description_BDA, "cover_bda", null, null));
        AssociationList.add(new Association("AbsINThe", 4, "logo_absinthe", "Alexandre Millero", "Grande salle du Foyer", description_absinthe, "cover_absinthe", null, null));



        AssoContainer.setRowCount(AssociationList.size()/2 + AssociationList.size()%2);

        int i = 0;
        for (Association asso : AssociationList)
        {
            GridLayout.Spec titleTxtSpecColumn = GridLayout.spec(i%2,GridLayout.FILL);
            GridLayout.Spec titleRowSpec = GridLayout.spec(i/2);
            FrameLayout frame = createFrame(asso);
            AssoContainer.addView(frame, new GridLayout.LayoutParams(titleRowSpec , titleTxtSpecColumn) );
            i++;
        }



    }

    private FrameLayout createFrame(final Association asso)
    {
        FrameLayout result = new FrameLayout(this);
        result.setLayoutParams(new FrameLayout.LayoutParams(AssoContainer.getWidth()/2,120));

        ImageButton button = new ImageButton(this);
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setBackgroundColor(Color.TRANSPARENT);
        button.setPadding(5,5,5,5);
        button.setImageResource(R.drawable.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),AssociationDetail.class);
                Bundle b = new Bundle();
                b.putParcelable("Asso",asso);
                i.putExtra("Association", b);
                startActivity(i);

            }
        });

        ImageView image = new ImageView(this);
        LinearLayout.LayoutParams imageParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        imageParam.gravity = Gravity.CENTER;
        image.setLayoutParams(imageParam);
        int imageId = getResources().getIdentifier(asso.getProfil_picture(),"drawable",getPackageName());
        image.setImageResource(imageId);
        image.setPadding(10,30,10,10);


        TextView text = new TextView(this);
        LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        textParam.gravity = Gravity.BOTTOM;
        text.setLayoutParams(textParam);
        text.setPadding(10,10,10,10);
        text.setText(asso.getName());
        text.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);


        result.addView(button);
        result.addView(image);
        result.addView(text);


        return result;
    }
}
