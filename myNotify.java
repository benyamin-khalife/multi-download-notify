    public static class myNotify{

        static ArrayList<cu> multiBuilder =new ArrayList<>();
        static   NotificationManager mNotifyManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        static String mTitle;

        private static class cu{
            public NotificationCompat.Builder mBuilder;
            public int id ;
        }
        private static NotificationCompat.Builder getBuiler(int notifyID){
            NotificationCompat.Builder t=null;
            for(int i=0;i<multiBuilder.size();i++){
                if (multiBuilder.get(i).id==notifyID) {
                    t=multiBuilder.get(i).mBuilder;
                    break;
                }
            }
            return t;
        }

        public static void build(String title,String smallText,int id,Intent intent,int color){
            mTitle=title;
            NotificationCompat.Builder mBuilder;

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent
                    pendingIntent = PendingIntent.getActivity(context, 0 /* Request code */, intent,
                    PendingIntent.FLAG_ONE_SHOT);


            mBuilder = new NotificationCompat.Builder(context);
            mBuilder.setContentTitle(title)
                    .setContentText(smallText)
                    .setContentIntent(pendingIntent)
                    .setColor(color)
                    .setAutoCancel(false)
                    .setSmallIcon(R.mipmap.ic_launcher);

            mBuilder.setProgress(100,0, false);
            mNotifyManager.notify(id, mBuilder.build());

            cu Temporary=new cu();
            Temporary.id=id;
            Temporary.mBuilder=mBuilder;

            multiBuilder.add(Temporary);
        }
        public static void update(int notifyID,int progress,float downloadSpeed){
            NotificationCompat.Builder builder=getBuiler(notifyID);
            //
            builder.setContentText(" | "+String.valueOf(progress)+"% | "+String.valueOf(Math.round( downloadSpeed))+" kB/s | ");
            builder.setProgress(100, progress, false);
            mNotifyManager.notify(notifyID,builder.build());
        }
        public static void completed(int notifyID,String title,String smallText,Intent intent,int color) {
            try {


                NotificationCompat.Builder
                        mBuilder = new NotificationCompat.Builder(context);


                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                PendingIntent
                        pendingIntent = PendingIntent.getActivity(context, 0 /* Request code */, intent,
                        PendingIntent.FLAG_ONE_SHOT);
                mBuilder.setContentIntent(pendingIntent);

                mBuilder.setContentTitle(title)
                        .setContentText(smallText)

                        .setAutoCancel(true)

                        .setSmallIcon(R.mipmap.ic_launcher);
                mBuilder.setColor(color);
                mNotifyManager.notify(notifyID, mBuilder.build());
            }catch (Exception e){Log.e("dl","completed >> Error");}
        }
    }
